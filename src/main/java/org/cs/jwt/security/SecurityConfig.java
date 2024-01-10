package org.cs.jwt.security;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;

import org.cs.jwt.security.jwt.JWTFilter;
import org.cs.jwt.security.jwt.TokenProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private WebApplicationContext applicationContext;

	@Autowired
	private DataSource dataSource;

	private AppUserDetailService userDetailsService;

	private final TokenProvider tokenProvider;

	public SecurityConfig(TokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	@PostConstruct
	public void completeSetup() {
		userDetailsService = applicationContext.getBean(AppUserDetailService.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		JWTFilter jwtFilter = new JWTFilter(this.tokenProvider);

	// @formatter:off
		http
		  .csrf().disable()
		  .cors()
		    .and()
		  .sessionManagement()
			  .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			  .and()
		//.httpBasic() // optional, if you want to access
		//  .and()     // the services from a browser
		  .authorizeRequests()
		    .antMatchers("/response/v1/data","/response/v1/networkstatus").permitAll()
		    .antMatchers("/getNewToken/*","/zipcode/**").permitAll()
			.anyRequest().authenticated()
		    .and()
		  .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		// @formatter:on
	}

	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()).and()
				.authenticationProvider(authenticationProvider()).jdbcAuthentication().dataSource(dataSource);
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}