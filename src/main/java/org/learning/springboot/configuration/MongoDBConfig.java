package org.learning.springboot.configuration;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "org.learning.springboot.mongodb.repositories")
public class MongoDBConfig {

    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(new ServerAddress("localhost", 27017));
    }

    @Bean
    public MongoDbFactory mongoDbFactory(){

        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient(),
                        "bidding_system");

        return  mongoDbFactory;
    }

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate2() {
        return new MongoTemplate(mongoDbFactory());
    }

}
