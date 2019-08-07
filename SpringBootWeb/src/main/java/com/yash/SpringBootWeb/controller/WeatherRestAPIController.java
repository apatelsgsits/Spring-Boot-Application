package com.yash.SpringBootWeb.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.SpringBootWeb.model.City;

@RestController
@RequestMapping("/restApi")
public class WeatherRestAPIController {
	
	final String uri = "http://restapi.demoqa.com/utilities/weather/city/";
	
	
	/*
	 * @GetMapping("/weather") public String welcome() {
	 * 
	 * return "weatherDetails";
	 * 
	 * }
	 */
	 
	
	@RequestMapping("/weather/{cityName}")
	public String getCityDetailsUsingRestTemplateAPIWithCunstomObjectMapper(@PathVariable("cityName") final String cityName,Model model ) {
		
		RestTemplate restTemplate=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String> entity= new HttpEntity<String>("parameters", headers);
		System.out.println("cityName :- "+cityName);
		ResponseEntity<Object> responseEntity=restTemplate.exchange(uri+cityName,HttpMethod.GET,entity,Object.class);
		ObjectMapper mapper = new ObjectMapper();
		City city=null;
		try {
			System.out.println("result.getBody():- "+responseEntity.getBody());
			System.out.println("new ObjectMapper().writeValueAsString(result.getBody()) :-"+new ObjectMapper().writeValueAsString(responseEntity.getBody()));
			city = mapper.readValue(new ObjectMapper().writeValueAsString(responseEntity.getBody()),City.class);
			System.out.println(city);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("In Exception :"+e.getMessage());
		}
		
		return city.toString();
	}
	
}
