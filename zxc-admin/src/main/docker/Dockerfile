FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD zxc-admin-1.0.jar app.jar
RUN sh -c 'touch /app.jar'
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai  /etc/localtime
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dlogging.file=/data/log/zxc-admin.log -jar /app.jar