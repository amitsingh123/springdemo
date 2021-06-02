package com.amit.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
      Custom Spring Security configuration
     */
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/accounts").authenticated()
            .antMatchers("/balance").authenticated()
            .antMatchers("/loans").authenticated()
            .antMatchers("/cards").authenticated()
            .antMatchers("/notice").permitAll()
            .antMatchers("/contact").permitAll()
                .antMatchers("/welcome").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }

    /*
        Configure user and its roles
     */
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        UserDetails user = User.withUsername("Amit").password("password").authorities("admin").build();
//        UserDetails user1 = User.withUsername("user").password("password").authorities("read").build();
//        userDetailsManager.createUser(user);
//        userDetailsManager.createUser(user1);
//        auth.userDetailsService(userDetailsManager);
//    }
//     Refer User from database
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource){
//        return  new JdbcUserDetailsManager(dataSource);
//    }
    //To fix :- java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}