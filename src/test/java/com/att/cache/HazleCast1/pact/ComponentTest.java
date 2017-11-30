package com.att.cache.HazleCast1.pact;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import com.att.cache.HazleCast1.service.ConsumerService;

public class ComponentTest {
 
	   ConsumerService consumerService = mock(ConsumerService.class);

	   @Test
	   public void greets() {
	   String msg = "Hello User!";
	   when(consumerService.getWelcomeMsg()).thenReturn(msg);
	   assertEquals(consumerService.getWelcomeMsg().toString(),"Hello User!");
	   }
	   
	}