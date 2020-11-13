package com.kakao.webtoon.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig { //extends AbstractMongoClientConfiguration {
    @Bean
    public MongoTransactionManager transactionManager(MongoDatabaseFactory mongoDbFactory) {
        return new MongoTransactionManager(mongoDbFactory);
    }

//    @Override
//    protected String getDatabaseName() {
//        return "kwtoon";
//    }
}
