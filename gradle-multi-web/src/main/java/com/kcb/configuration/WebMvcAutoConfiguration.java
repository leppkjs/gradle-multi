package com.kcb.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.kcb.filter.RSABodyFilter;
import com.kcb.filter.RSAFilter;

/**
 * 웹 설정 정보 이다.
 * 
 * @author O117012
 */
@Configuration
public class WebMvcAutoConfiguration extends WebMvcConfigurerAdapter{
	
	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] {"WEB-INF/tiles/tiles.xml"});
		configurer.setCheckRefresh(true);
		return configurer;
	}
	
	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}
	
	/**
	 * message source을 등록함
	 * @return
	 */
	/*
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/messages/message", "classpath:/messages/validation");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(0);
		
		return messageSource;
	}
	*/
	
	@Bean
	public FilterRegistrationBean rSAFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new RSAFilter());
		registrationBean.setOrder(2);
		return registrationBean;
	}
	
	@Bean
	public FilterRegistrationBean rSABodyFilterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new RSABodyFilter());
		registrationBean.setOrder(3);
		return registrationBean;
	}
}
