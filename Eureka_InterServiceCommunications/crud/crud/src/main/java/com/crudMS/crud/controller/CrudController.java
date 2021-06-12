package com.crudMS.crud.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {
 
	@RequestMapping(value="/crudHome",method=RequestMethod.GET)
	public String  getHome() {
		return "Hello from home crud ms";
	}
	
	@RequestMapping(value="/crudHome/{name}",method=RequestMethod.GET)
	public String  getHome(@PathVariable String name) {
		return "Hello "+name+" from home crud ms";
	}
}
