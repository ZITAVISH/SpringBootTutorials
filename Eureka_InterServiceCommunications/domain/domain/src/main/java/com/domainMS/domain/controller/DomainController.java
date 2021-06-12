package com.domainMS.domain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DomainController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	Logger logger = LoggerFactory.getLogger(DomainController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET,consumes = "application/json",produces="application/json")
	public ResponseEntity<String> getHome() {
		try {
			ServiceInstance instance = discoveryClient.getInstances("crudms").get(0);
			String crudUrl = instance.getUri().toString();
			logger.info(crudUrl);
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<String> crudResponseEntity = restTemplate.exchange(crudUrl + "/crudHome", HttpMethod.GET,
					requestEntity, String.class);
			String crudResponse = crudResponseEntity.getBody();
			logger.info("Crud Response : {}", crudResponse);
			return new ResponseEntity<>(crudResponse + " and Hello from home domain ms ",HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception occured : {}", ex);
			return new ResponseEntity<>("Exception occured in crud layer , Hello from home domain ms ",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/home/{name}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> getHomeWithName(@PathVariable String name) {
		try {
			ServiceInstance instance = discoveryClient.getInstances("crudms").get(0);
			String crudUrl = instance.getUri().toString();
			logger.info(crudUrl);
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<Object> requestEntity = new HttpEntity<>(headers);
			ResponseEntity<String> crudResponseEntity = restTemplate.exchange(crudUrl + "/crudHome/" + name,
					HttpMethod.GET, requestEntity, String.class);
			String crudResponse = crudResponseEntity.getBody();
			logger.info("Crud Response : {}", crudResponse);
			return new ResponseEntity<>(crudResponse + " and Hello from home domain ms ", HttpStatus.OK);
		} catch (Exception ex) {
			logger.error("Exception occured : {}", ex);
			return new ResponseEntity<>("Exception occured in crud layer , Hello from home domain ms ",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
