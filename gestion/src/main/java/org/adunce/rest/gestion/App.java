package org.adunce.rest.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.mangofactory.swagger.plugin.EnableSwagger;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableSwagger
public class App extends SpringBootServletInitializer
{
	
	public static final String RESOURCE_ID = "blog_resource";
	
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }
}
