package com.oauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class JwtResourceConfig extends ResourceServerConfigurerAdapter {

	@Value("${security.jwt.secret:secret}")
	private String secret;
	
	@Bean
	public JwtAccessTokenConverter accessToken() {
		JwtAccessTokenConverter convert = new JwtAccessTokenConverter();
		convert.setSigningKey(secret);
		return convert;
	}
	
	public TokenStore token() {
		return new JwtTokenStore(accessToken());
	}
	
	@Bean
	public DefaultTokenServices defaultTokenResource() {
		DefaultTokenServices def = new DefaultTokenServices();
		def.setTokenStore(token());
		return def;
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer config) throws Exception {
		config.tokenServices(defaultTokenResource());
	}
	
	@Override
	public void configure(HttpSecurity security) throws Exception {
		security
			//cors was seting in CorsConfig class, by default cors is enabled
			//.cors()
			//.and()
			//csrf disabled because :
			//1. You are using another token mechanism, that's oauth2.
			//2. You want to simplify interactions between a client and the server.
			.csrf()
			.disable()
			.authorizeRequests()
			//security.basic.enabled => deprecated in springboot 2.
			//So use .anyRequest().permitAll()
			.anyRequest()
			.permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedHandler(new OAuth2AccessDeniedHandler());
	}
}
