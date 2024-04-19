package com.example.demo.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Bean
    open fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/hello-all").permitAll()
            .antMatchers("/hello-user").hasRole("USER")
            .antMatchers("/hello-admin").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .httpBasic()
    }
}
