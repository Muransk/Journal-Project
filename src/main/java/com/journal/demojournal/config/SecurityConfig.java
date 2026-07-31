package com.journal.demojournal.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.journal.demojournal.services.UsersDetailsService;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UsersDetailsService usersDetailsService;


    @Autowired
    public SecurityConfig(UsersDetailsService usersDetailsService) {
        this.usersDetailsService = usersDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
        .csrf(csrf -> csrf.disable()) 
        .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated()
        )
                
                .formLogin(form -> form
                    .defaultSuccessUrl("/students", false)
                    .permitAll()         
                );  

        return http.build();
    }


    
   // protected void configurer(AuthenticationManagerBuilder auth){
     //   auth.authenticationProvider(authProvider); 
    //}
    // @Bean
    //public UsersDetailsService usersDetailsService() {
      //  return usersDetailsService;
  //  }


    //@Bean
    //public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
      //  return configuration.getAuthenticationManager();
    //}

    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }
}
  