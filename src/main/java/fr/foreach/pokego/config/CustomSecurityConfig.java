package fr.foreach.pokego.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
               .anyRequest().permitAll()
               .and()
               .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("password2"))
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password(passwordEncoder().encode("password2"))
                .roles("USER");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
