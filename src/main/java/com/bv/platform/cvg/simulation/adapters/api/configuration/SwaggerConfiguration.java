package com.bv.platform.cvg.simulation.adapters.api.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private static final String TITLE_API = "titulo aqui"; 
	private static final String TITLE_VERSION = "Version: ?.?";
	private static final String MAIN_PACKEGE = "com.bv.platform.cvg.simulation";
	private static final String VERSION = " ?.??";
	private static final String TERMS_OF_SERVICE = "Terms of Service";
	private static final String AUTHOR = "Cleiton Silva";
	private static final String LINKEDIN = "https://www.linkedin.com/in/cleiton-silva-b08535101/";
	private static final String EMAIL = "cleitoncs@ciandt.com";
	private static final String LICENSE = "Apache License Version 2.0";
	private static final String LICENSE_LINK = "https://www.apache.org/licesen.html";
	
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(MAIN_PACKEGE))
                .paths(regex("/.*"))
                .build()
                .apiInfo(appInfo());
    }

    private ApiInfo appInfo() {

        ApiInfo apiInfo = new ApiInfo(
                TITLE_API,
                TITLE_VERSION,
                VERSION,
                TERMS_OF_SERVICE,
                new Contact(AUTHOR, LINKEDIN, EMAIL),
                LICENSE,LICENSE_LINK, new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }

}
