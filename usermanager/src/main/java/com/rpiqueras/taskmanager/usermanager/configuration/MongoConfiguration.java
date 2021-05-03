package com.rpiqueras.taskmanager.usermanager.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.StringUtils;

/**
 *
 */
@Configuration
// @Profile("!test && !integration")
public class MongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String mongoDatabase;

    @Value("${spring.data.mongodb.user}")
    private String mongoUser;

    @Value("${spring.data.mongodb.password}")
    private String mongoPassword;

    @Bean
    public MongoClient mongo() {
        final ConnectionString connectionString = new ConnectionString(mongoUri);
        MongoClientSettings.Builder mongoClientSettingsBuilder = MongoClientSettings.builder()
                .applyConnectionString(connectionString);
        if (!StringUtils.isEmpty(mongoUser) && !StringUtils.isEmpty(mongoPassword)) {
            mongoClientSettingsBuilder.credential(MongoCredential.createCredential(mongoUser, mongoDatabase, mongoPassword.toCharArray()));
        }
        final MongoClientSettings mongoClientSettings = mongoClientSettingsBuilder.build();
        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), mongoDatabase);
    }
}
