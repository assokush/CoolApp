package com.iclout.runner.roman.config;
import com.iclout.runner.roman.inter.Coach;
import com.iclout.runner.roman.inter.impl.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach(){
        return  new SwimCoach();
    }
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=? ");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=? ");
        return jdbcUserDetailsManager;
    }
  @Bean
  public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
      httpSecurity.authorizeHttpRequests(configurer ->
              configurer
                      .requestMatchers(HttpMethod.GET, "/api/base").hasAnyRole("EMPLOYEE")
                      .requestMatchers(HttpMethod.GET, "/api/workout").hasRole("MANAGER")
                      .requestMatchers(HttpMethod.GET, "/api/check").hasRole("ADMIN")
                      .requestMatchers(HttpMethod.GET, "/api/fortune").hasRole("EMPLOYEE")
                      .requestMatchers(HttpMethod.GET, "/api/workoutV2").hasRole("MANAGER")
      );
      //https://www.bcryptcalculator.com/encode
      //Use spring security basic authentication and disable csrf - csrf is required for non stateless rest calls without form
                 httpSecurity.httpBasic(Customizer.withDefaults());
                 httpSecurity.csrf(csrf -> csrf.disable());

                 return httpSecurity.build();
  }

  // john fun123

  /*   @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);

    }*/
}
