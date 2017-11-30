package com.att.cache.HazleCast1;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IQueue;

@Configuration
//@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,HazelcastAutoConfiguration.class })
public class HazleCastConfig {
	
	 @Bean
		public HazelcastInstance hazlecastInstance() {
			// Create a cache first
			/*
			 * Config cfg = new Config(); cfg.setInstanceName("DMaaPQ");
			 * HazelcastInstance instance = Hazelcast.newHazelcastInstance(cfg);
			 */
			 HazelcastInstance instance = Hazelcast.newHazelcastInstance();
		        System.out.println(">>>>>>>>>>>>>"+instance.getConfig().getNetworkConfig());
			return instance;
		}
	    
		@Bean
		public IQueue<String> eventContextObjsQ(HazelcastInstance hci) {
			IQueue<String> queue = hci.getQueue("ecoQ");
			return queue;
		}
		
}
