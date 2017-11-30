package com.att.cache.HazleCast1;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import com.att.ajsc.common.utility.MDCInitializer;
import com.att.ajsc.common.utility.SystemPropertiesLoader;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableAsync
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
    	SystemPropertiesLoader.addSystemProperties(); 
    	MDCInitializer.initMDCData();
    	MDCInitializer.setThreadId();
        SpringApplication.run(Application.class, args);
    }
    
}