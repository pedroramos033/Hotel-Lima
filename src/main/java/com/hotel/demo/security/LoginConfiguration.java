 /* package com.hotel.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hotel.demo.interfacesService.IUsuarioService;

@Configuration
@EnableWebSecurity


public class LoginConfiguration extends WebSecurityConfiguration {
	
	
	@Autowired
	private IUsuarioService iUsuarios;

   
	@Bean
    public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

 
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    	auth.setUserDetailsService(iUsuarios);
    	auth.setPasswordEncoder(passwordEncoder());
    	
    	return auth;
	}}
   
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    	auth.authenticationProvider(authenticationProvider());
    }
   
   
	@SuppressWarnings({ "deprecation", "removal" })
	protected void configure(HttpSecurity http) throws Exception{
    	http.authorizeRequests().anyRequest().authenticated()
    	.and()
    	.formLogin()
    	.loginPage("/Login")
    	.permitAll()
    	.and()
    	.logout()
    	.invalidateHttpSession(true)
    	.clearAuthentication(true)
    	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    	.logoutSuccessUrl("/login?logout")
    	.permitAll();
    	
    }
    
   
	
}
*/




