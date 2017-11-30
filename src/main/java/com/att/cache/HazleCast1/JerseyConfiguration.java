package com.att.cache.HazleCast1;

import java.util.logging.Logger;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.att.ajsc.common.messaging.DateTimeParamConverterProvider;
import com.att.ajsc.common.messaging.TransactionIdResponseFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.att.ajsc.common.messaging.TransactionIdRequestFilter;
import com.att.cache.HazleCast1.service.rs.RestServiceImpl;

@Component
@ApplicationPath("/")
public class JerseyConfiguration extends ResourceConfig {
	private static final Logger log = Logger.getLogger(JerseyConfiguration.class.getName());
	
	@Bean
	@Primary
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
		objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		return objectMapper;
	}
	
	@Autowired
    public JerseyConfiguration() {
		register(RestServiceImpl.class);
        property(ServletProperties.FILTER_FORWARD_ON_404, true);
        register(TransactionIdRequestFilter.class, 6000);
        register(TransactionIdResponseFilter.class, 6003);
        register(DateTimeParamConverterProvider.class);
        register(new LoggingFilter(log, true));
    }

	@Bean
	public Client jerseyClient() {
		return ClientBuilder.newClient(
				new ClientConfig()
				.register(TransactionIdRequestFilter.class)
				.register(TransactionIdResponseFilter.class)
				.register(DateTimeParamConverterProvider.class));
	}
}