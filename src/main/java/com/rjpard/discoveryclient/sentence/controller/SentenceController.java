package com.rjpard.discoveryclient.sentence.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;



@Controller
public class SentenceController {

	@Autowired DiscoveryClient client;
	
	@GetMapping("/sentence")
	public @ResponseBody String getSentence() {
	  return String.format("%s %s %s %s %s.",
		  getWord("RJPARD-DISCOVERYCLIENT-SUBJECT"),
		  getWord("RJPARD-DISCOVERYCLIENT-VERB"),
		  getWord("RJPARD-DISCOVERYCLIENT-ARTICLE"),
		  getWord("RJPARD-DISCOVERYCLIENT-ADJECTIVE"),
		  getWord("RJPARD-DISCOVERYCLIENT-NOUN") );
	}

	public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
      	URI uri = list.get(0).getUri();
	      	if (uri !=null ) {
	      		return (new RestTemplate()).getForObject(uri,String.class);
	      	}
        }
        return null;
	}

}
