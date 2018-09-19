#!/usr/bin/env bash
#bash!

allapps="zxc-config,zxc-service-register,zxc-api-gateway,zxc-auth,zxc-blog"

function usage() {
  echo "Usage: $0 [-r <dockerRegistryIp:port>] [microService name]"
}

while getopts 'r:' OPT; do
  case $OPT in
    r)
      DOCKER_REG="$OPTARG";;
    ?)
      usage
      exit 1
  esac
done

shift $(($OPTIND - 1))

if [ -z $1 ]; then
  apps=$allapps
else
  apps=$1
fi

if [ -n "$DOCKER_REG" ]; then
  MVN_OPT="-Ddocker.image.prefix=$DOCKER_REG"
fi

echo ${apps}

mvn clean install -pl ${apps} -am

apps=${apps//,/ }
for app in $apps
do
	echo =====================================================================================
    	echo build docker image [$app]
 	cd ./$app;mvn $MVN_OPT docker:build docker:push
	cd ..
done 

sleep 10s
docker rmi -f $(docker images -f dangling=true -q)
