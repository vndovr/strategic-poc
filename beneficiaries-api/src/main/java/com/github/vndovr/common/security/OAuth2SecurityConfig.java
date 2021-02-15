package com.github.vndovr.common.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.github.vndovr.Profiles;

@EnableWebSecurity
@Profile(Profiles.STAGING)
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${spring.h2.console.enabled:false}")
  private boolean h2ConsoleEnabled;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    (h2ConsoleEnabled ? http.headers().frameOptions().disable().and() : http).cors().and().csrf()
        .disable().authorizeRequests().antMatchers("/api/openapi.json").permitAll()
        .antMatchers("/api/**").authenticated().anyRequest().permitAll().and()
        .oauth2ResourceServer().jwt();
  }
}
