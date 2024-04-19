package com.example.demo.security

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class ApplicationUserDetailsService : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val passwordEncoder = BCryptPasswordEncoder()

        return when (username) {
            "user" -> User(username, passwordEncoder.encode("password"), listOf(SimpleGrantedAuthority("ROLE_USER")))
            "admin" -> User(username, passwordEncoder.encode("adminpassword"), listOf(SimpleGrantedAuthority("ROLE_ADMIN")))
            else -> throw UsernameNotFoundException("User not found")
        }
    }
}
