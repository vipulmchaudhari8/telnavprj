package com.telnavprj.dao;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
          .driverClassName("com.mysql.jdbc.Driver")
          .url("jdbc:mysql://localhost:3306/telnavdb")
          .username("root")
          .password("root")
          .build();	
    }
}