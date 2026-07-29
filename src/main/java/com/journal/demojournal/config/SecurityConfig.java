package com.journal.demojournal.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
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
                .anyRequest().authenticated()
        )
                //.requestMatchers("/api/auth/**").permitAll()
                .formLogin(form -> form
                    .defaultSuccessUrl("/students", false)
                    .permitAll()
                );  

        return http.build();
    }

   /*  @Bean
    public DaoAuthenticationProvider authenticationProvider(){// добавлено, хз будет ли работать
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(usersDetailsService);
        provider.setPasswordEncoder(getPasswordEncoder());
        return provider;
    }
    
   // protected void configurer(AuthenticationManagerBuilder auth){
     //   auth.authenticationProvider(authProvider); 
    //}
     @Bean
    public UsersDetailsService usersDetailsService() {
        return usersDetailsService;
    }*/


    //@Bean
    //public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
      //  return configuration.getAuthenticationManager();
    //}

    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return NoOpPasswordEncoder.getInstance();
    }
}
  