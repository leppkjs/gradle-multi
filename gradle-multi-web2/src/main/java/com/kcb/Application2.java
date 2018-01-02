package com.kcb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.kcb")
public class Application2 extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application2.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Application2.class, args);
	}
	
	//TODO 스프링부트 임베디드 톰켓한테 강제로 도큐먼트루트를 바라보게 하는 방법
	/*
	@Bean
	public EmbeddedServletContainerCustomizer documentRootConfigurer() {
	    return new EmbeddedServletContainerCustomizer() {
	    	@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.setDocumentRoot(new File("build/resources/main"));
				
			}
		};
	}
	*/
}
