package com.Monty.Ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.Monty.Ecommerce.security.jwt.AuthEntryPointJwt;
import com.Monty.Ecommerce.security.jwt.AuthTokenFilter;
import com.Monty.Ecommerce.security.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import com.Monty.Ecommerce.security.services.UserDetailsServiceImpl;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(// securedEnabled = true,// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
	return new AuthTokenFilter();
    }
    
    @Bean
    public JwtUsernameAndPasswordAuthenticationFilter authenticationFilter() throws Exception {
        JwtUsernameAndPasswordAuthenticationFilter authenticationFilter = new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager());
        authenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/v1/signin", "POST"));
        authenticationFilter.setAuthenticationManager(authenticationManagerBean());
        return authenticationFilter;
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
	return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors().and().csrf().disable()
    		.exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .addFilter(authenticationFilter())
                .addFilterAfter(authenticationJwtTokenFilter(), JwtUsernameAndPasswordAuthenticationFilter.class)
    		.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
    		.authorizeRequests()
                .antMatchers("/api/v1/signup").permitAll()
                .antMatchers("/api/v1/signin").permitAll()
                .antMatchers("/api/v1/address/**").hasRole("USER")
    		//.antMatchers("/api/v1/**").permitAll()
    		//.anyRequest().authenticated();
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .logoutSuccessUrl("/index");

    	//http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        /*http.addFilterBefore(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(authenticationJwtTokenFilter(), JwtUsernameAndPasswordAuthenticationFilter.class);*/
    }
}
