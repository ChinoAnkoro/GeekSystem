package main.java.com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import main.java.com.example.demo.service.AdminDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers(
						"/admin/signup",
						"/admin/signin",
						"/admin/login").permitAll().anyRequest().authenticated())
				.formLogin(form -> form
						.loginPage("/admin/signin")
						.loginProcessingUrl("/admin/login")
						.usernameParameter("email")
						.passwordParameter("password")
						.defaultSuccessUrl("/admin/top", true)
						.failureUrl("/admin/signin?error")
						.permitAll())
				.logout(logout -> logout
				                .logoutUrl("/admin/logout")
				                .logoutSuccessUrl("/admin/signin")
				            );
		return http.build();
	}
	
	public UserDetailsService userDetailsService(AdminDetailServiceImpl service) {
		return service;
	}
}
