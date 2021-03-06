package com.Monty.Ecommerce.security.jwt;

import static com.Monty.Ecommerce.security.jwt.JwtUsernameAndPasswordAuthenticationFilter.getToken;
import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Monty.Ecommerce.security.services.UserDetailsServiceImpl;
import java.util.Date;
import org.springframework.security.core.Authentication;

public class AuthTokenFilter extends OncePerRequestFilter {
	
    @Autowired
    private JwtUtils jwtUtils;
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
    
    String globalToken = "";
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = "";
                try {
		jwt = parseJwt(request);
		if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                    String username = jwtUtils.getUserNameFromJwtToken(jwt);
                    UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
		}
	} catch (Exception e) {
            logger.error("Cannot set user authentication: {}", e);
	}
        System.out.println("2 " + new Date() + " " + globalToken);
        response.addHeader("Authorization",  "Bearer " + globalToken);
	filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
	String headerAuth = getToken();
        globalToken = headerAuth;
	if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
	}
        System.out.println("3 " + new Date() + " " + globalToken);
	return globalToken;
    }
}
