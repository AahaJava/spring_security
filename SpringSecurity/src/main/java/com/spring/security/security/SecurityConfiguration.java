package com.spring.security.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	PasswordEncoder encoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()
        /*csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())*/)
                .authorizeRequests(requests -> requests
                        .antMatchers("/public/**").hasRole("NORMAL")
                        .antMatchers("/users/**").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated())
                .httpBasic(withDefaults());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {

		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		builder.inMemoryAuthentication()
		.withUser("asif").password(encoder.encode("1234")).roles("USER").and()
		.withUser("john").password(encoder.encode("1234")).roles("NORMAL").and()
		.withUser("abrar").password(encoder.encode("1234")).roles("ADMIN");
	}

    @Bean
    PasswordEncoder getPasswordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}