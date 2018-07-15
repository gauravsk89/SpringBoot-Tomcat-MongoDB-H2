package org.learning.springboot.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.learning.springboot.oracle.domain"})
@EnableJpaRepositories(basePackages = {"org.learning.springboot.oracle.repositories"})
@EnableTransactionManagement
public class H2DBConfig {

    String[] ENTITY_PATH = {"org.learning.springboot.oracle.domain"};

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataSource());
        em.setPackagesToScan(ENTITY_PATH);
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(additionalJpaProperties());
        em.setPersistenceUnitName("H2_PersistanceUnit");

        return em;
    }

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:bidding_system")
                .driverClassName("org.h2.Driver")
                .username("sa")
                .password("sa")
                .build();
    }

    Properties additionalJpaProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }

}