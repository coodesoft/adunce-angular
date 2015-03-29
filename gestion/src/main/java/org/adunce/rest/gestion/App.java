package org.adunce.rest.gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mangofactory.swagger.plugin.EnableSwagger;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableSwagger
public class App
{
	
	public static final String RESOURCE_ID = "blog_resource";
	
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }
}
