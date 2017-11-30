package com.att.cache.HazleCast1.service;

import org.springframework.stereotype.Service;

import com.att.ajsc.common.Tracable;
import com.att.cache.HazleCast1.common.LogMessages;

import com.att.cache.HazleCast1.model.HelloWorld;
import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;

@Service
public class SpringServiceImpl implements SpringService {
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(SpringServiceImpl.class);
	public SpringServiceImpl() {
		// needed for instantiation
	}

	@Override
	@Tracable(message="invoking quick hello service ")
	public HelloWorld getQuickHello(String name) {
		log.info(LogMessages.SPRINSERVICE_HELLO);
		log.debug(LogMessages.SPRINSERVICE_HELLO_NAME, name);
		if (name == null || name.isEmpty()) {
			name = "world";
		}
		String message = "Hello " + name + "!";
		log.debug(LogMessages.SPRINSERVICE_HELLO_MESSAGE, message);
		HelloWorld hello = new HelloWorld(message);
		log.debug(LogMessages.SPRINSERVICE_HELLO_MESSAGE_NAME, hello.toString());
		return hello;
	}
}