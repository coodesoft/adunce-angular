package org.adunce.rest.gestion.config;

import org.adunce.rest.gestion.filters.CsrfHeaderFilter;
import org.adunce.rest.gestion.services.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;


@Configuration
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    private CurrentUserDetailsService userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(new BCryptPasswordEncoder())
				.and()
			.inMemoryAuthentication()
				.withUser("user").password("user").roles("USER")
				.and()
				.withUser("admin").password("admin").roles("ADMIN")
				.and()
				.withUser("alumno").password("alumno").roles("ALUMNO");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		//Esto es para desarrollo,si open es true entonces se desactiva la seguridad.
		boolean open=false;
		if (open){
			http.httpBasic().and().authorizeRequests().anyRequest().permitAll().and().csrf().disable();
		} else {
			http
				.httpBasic().and()
				.authorizeRequests()
					.anyRequest()
						.authenticated()
						.and()
				.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
				.csrf()
					.csrfTokenRepository(csrfTokenRepository());
		}
	}
	
	private CsrfTokenRepository csrfTokenRepository() {
		  HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		  repository.setHeaderName("X-XSRF-TOKEN");
		  return repository;
		}
	
}
