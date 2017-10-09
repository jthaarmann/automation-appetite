package com.jth.example.dashboard.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jth.example.dashboard.service.RestProxyService;

@RestController
@RequestMapping(value={"/entities", "/services"})
public class RestProxyController {

	@Autowired
	RestProxyService restProxyService;

	@RequestMapping(value="/**", method = RequestMethod.GET)
	@ResponseBody public String restProxyGet(HttpServletRequest request) {
		String restUrlPath = getRestUrl(request);
		return restProxyService.get(restUrlPath);
	}

	@RequestMapping(value="/**", method = RequestMethod.POST)
	 @ResponseBody public String restProxyPost(@RequestBody String body, HttpServletRequest request) {
		String restUrlPath = getRestUrl(request);
	    return restProxyService.post(restUrlPath, body);
	}

	private String getRestUrl(HttpServletRequest request) {
		String requestURI = request.getRequestURI() + "?" + request.getQueryString();
		String restUrlPath;
		if(requestURI.contains("/entities")) {
			restUrlPath = requestURI.substring(requestURI.indexOf("/entities"));
		} else {
			restUrlPath = requestURI.substring(requestURI.indexOf("/services"));
		}
			
		return restUrlPath;
	}
	
}
