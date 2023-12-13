package org.example.ontapck2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails u1 = User.builder()
                .username("admin")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("ADMIN")
                .build();

        UserDetails u2 = User.builder()
                .username("user")
                .password(new BCryptPasswordEncoder().encode("123"))
                .roles("USER")
                .build();

        auth.inMemoryAuthentication()
                .withUser(u1)
                .withUser(u2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(auth ->
                auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/report2").hasRole("ADMIN")
                        .requestMatchers("/index", "/candidate/**", "/report1").hasRole("USER")
                        .anyRequest().authenticated()
        );
        http.formLogin(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
