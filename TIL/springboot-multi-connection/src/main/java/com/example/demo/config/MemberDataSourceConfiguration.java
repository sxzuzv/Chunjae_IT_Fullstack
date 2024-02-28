package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(sqlSessionFactoryRef = "memberSqlSessionFactory")
public class MemberDataSourceConfiguration {
    @Primary
    @Bean(name = "memberDataSource")
    @ConfigurationProperties(prefix = "spring.member.datasource")
    public DataSource memberDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "memberSqlSessionFactory")
    public SqlSessionFactory memberSqlSessionFactory(@Qualifier("memberDataSource") DataSource memberDataSource,
                                                    ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // memberDataSource()로부터 받아온 memberDataSource를 가지고 Connection을 위한 정보를 세팅한다.
        sqlSessionFactoryBean.setDataSource(memberDataSource);

        sqlSessionFactoryBean.setTypeAliasesPackage("com.test.api.entity, com.test.api.vo");

        // 동일한 경로로 설정 시, 충돌이 발생한다.
        // member 하위의 폴더 및 xml 파일에 대해서 경로를 설정해준다.
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(
                "classpath:mappers/member/**/*.xml"));

        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(
                "classpath:mybatis-config.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "memberSqlSessionTemplate")
    public SqlSessionTemplate memberSqlSessionTemplate(@Qualifier(
            "memberSqlSessionFactory") SqlSessionFactory memberSqlSessionFactory) {
        return new SqlSessionTemplate(memberSqlSessionFactory);
    }
}

