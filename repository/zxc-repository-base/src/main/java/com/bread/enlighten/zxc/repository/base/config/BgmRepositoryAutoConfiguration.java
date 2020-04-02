package com.bread.enlighten.zxc.repository.base.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

/**
 * 2019-07-17 10:51
 * @author xianyi
 */
@Configuration
@ComponentScan("com.bread.enlighten.zxc.repository")
@Log4j2
public class BgmRepositoryAutoConfiguration {

    @PostConstruct
    public void init() {
        log.info("༼´◓ɷ◔`༽  BGM Repository loaded");
    }

    /**
     * Mysql配置
     */
    @Configuration
    @ConditionalOnClass({SqlSessionFactory.class, SqlSessionFactoryBean.class})
    @AutoConfigureAfter({DataSourceAutoConfiguration.class})
    @EnableTransactionManagement
    @MapperScan(basePackages = "com.mobtech.bgm.repository.*.mapper")
    @EnableConfigurationProperties(MybatisPlusProperties.class)
    public static class MysqlAutoConfiguration {

        private MybatisPlusProperties properties;

        public MysqlAutoConfiguration(MybatisPlusProperties properties) {
            this.properties = properties;
            properties.setMapperLocations(new String[]{"classpath*:/mybatis/mapper/*.xml",
                "classpath*:/mybatis/mapper/**/*.xml"});
            if (properties.getGlobalConfig() == null) {
                properties.setGlobalConfig(new GlobalConfig());
            }

//            properties.setTypeAliasesSuperType(BaseModel.class);
            properties.setTypeAliasesPackage("com.integrate.zxc.repository.*.entity");
            properties.setTypeHandlersPackage("com.mobdata.ad.common.dao.mysql.mybatis.handler,"
                + "com.mobtech.bgm.repository.*.handler");

            //枚举包扫描
            properties.setTypeEnumsPackage("com.mobtech.bgm.repository.*.enums");
        }

        @PostConstruct
        public void init() {
            log.info("┌(ㆆ㉨ㆆ)ʃ BGM Repository Mysql config loading");
        }

//        @Bean
//        @Primary
//        MybatisPlusProperties mybatisPlusProperties() {
//            properties.getGlobalConfig().setMetaObjectHandler(metaObjectHandler());
//            return properties;
//        }
//
//        /**
//         * 公共字段自动填充
//         * @return 公共字段填充handler
//         */
//        @Bean
//        MetaObjectHandler metaObjectHandler() {
//            return new MybatisPlusMetaObjectHandler();
//        }

    }
}
