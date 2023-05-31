package com.xtb.restful.config;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

//    @Value("${hsqldb.client.enable}")
//    private boolean enable;

    @Bean(name = "dataSourceH2")
    @Primary
    public DataSource hsqlDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScripts(
                    "/schema-all.sql"
                )
                .build();
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate hsqlJdbcTemplate(@Qualifier("dataSourceH2") DataSource hsqlDataSource) {
        return new JdbcTemplate(hsqlDataSource);
    }

//    @PostConstruct
//    public void hsqldbClient() {
//        Boolean enable = true;
//        if (enable) {
//            DatabaseManagerSwing.main(new String[]
//                    { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", ""});
//        }
//    }
}
