package game.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security configuration class
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Configuration method for authentication via database
     */
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery("select username,password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }

    /**
     * Configuration method for security
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/home")
                .and()
                    .authorizeRequests()
                    .antMatchers("/dashboard", "addMatch").authenticated()
                    .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                    .anyRequest().permitAll()
                //.and()
                //    .exceptionHandling().accessDeniedPage("/403")
                .and()
                    .csrf().disable();

    }
}