package fr.foreach.pokego.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .authorizeRequests()
               .antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
               .antMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
               .antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
               .antMatchers(HttpMethod.GET, "/**").hasAnyRole("USER", "ADMIN")
               .anyRequest().authenticated()
               .and()
               .httpBasic();
    }







}
