package com.example.aplicativo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configuración de usuarios en memoria (solo para prueba, usar autenticación real en producción)
        auth.inMemoryAuthentication()
            .withUser("admin")
            .password(passwordEncoder().encode("admin123"))
            .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorize -> {
                authorize
                    .antMatchers("/api/**").hasRole("ADMIN") // Configurar permisos por roles
                    .anyRequest().authenticated(); // Todas las demás peticiones requieren autenticación
            })
            .httpBasic(); // Usar autenticación básica HTTP
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
