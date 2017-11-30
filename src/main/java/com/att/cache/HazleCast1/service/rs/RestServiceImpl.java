package com.att.cache.HazleCast1.service.rs;

import java.util.Iterator;

import javax.ws.rs.core.Response;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.att.ajsc.common.Tracable;
import com.att.cache.HazleCast1.common.LogMessages;
import com.att.cache.HazleCast1.model.HelloWorld;
import com.att.cache.HazleCast1.service.SpringService;
import com.att.ajsc.logging.AjscEelfManager;
import com.att.eelf.configuration.EELFLogger;
import com.hazelcast.core.IQueue;

@Component
public class RestServiceImpl implements RestService {
	private static EELFLogger log = AjscEelfManager.getInstance().getLogger(RestServiceImpl.class);
	
	@Autowired
	private IQueue<String> objQ;
	
	@Autowired
	private SpringService service;
	
	public RestServiceImpl() {
	}

	@Override
	@Tracable(message="invoking quick hello")
	public Response getQuickHello(String name) {
		log.info(LogMessages.RESTSERVICE_HELLO);
		log.debug(LogMessages.RESTSERVICE_HELLO_NAME, name);
		HelloWorld hw = service.getQuickHello(name);
		return Response.ok().entity(hw).build();
	}
	
	public String updateCache(){
		System.out.println("in the update cache");
		objQ.add(new DateTime().toString());
		return "HazleCast-1 : After update, cache size is : "+Integer.toString(objQ.size());
		
	}
	
	public String getCacheSize(){
		System.out.println("in the getCacheSize");
		System.out.println("Cache Size :" + objQ.size());
		return "Hazlecast-1 : Cache Size :"+Integer.toString(objQ.size());
	}
	
	public String showCache(){
		Iterator<String> it = objQ.iterator();
		String response = "HazleCast-2 : Cache is looking like this :";
		while (it.hasNext()) {
			response = response+"\n" + it.next();
		}
		return response;
	}

	public String deleteFromCache(){
		try {
			objQ.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "HazleCast-1 : After DELETE, cache size is : "+Integer.toString(objQ.size());
	}
}
