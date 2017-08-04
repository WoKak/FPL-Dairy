package game.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.sql.DataSource;

/**
 * Created by Michał on 2017-04-01.
 * Beans configuration class
 */

@Configuration
@PropertySource(value = {"classpath:database/database.properties"})
public class AppConfig {

    @Autowired
    private Environment env;

    /**
     * Database bean
     */
    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(env.getRequiredProperty("jdbc.drivers"));
        ds.setUrl(env.getRequiredProperty("jdbc.url"));
        ds.setUsername(env.getRequiredProperty("jdbc.username"));
        ds.setPassword(env.getRequiredProperty("jdbc.password"));

        return ds;
    }

    /**
     * Encoder bean
     */
    @Bean
    public PasswordEncoder passwordEncoder(){

        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
