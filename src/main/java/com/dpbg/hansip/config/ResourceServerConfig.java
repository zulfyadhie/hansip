package com.dpbg.hansip.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * Created by zulfyadhie on 2/12/17.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.anonymous().disable()
                .authorizeRequests()
                .antMatchers("/home")
                .access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

}