package kr.ac.hs.se.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/reservation?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PW = "2277";

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PW);
        return dataSource;
    }

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManger();
    }

    @Bean
    public PlatformTransactionManager transactionManger() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate jdbc(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public SimpleJdbcInsert insertAction(DataSource dataSource) {
        return new SimpleJdbcInsert(dataSource);
    }
}