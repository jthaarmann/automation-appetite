package com.jth.example.dashboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestProxyServiceImpl implements RestProxyService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${rest.proxy.target.base.url}")
	String targetBaseUrl;
	
	@Override
	public String get(String restUrlPath) {
		String url = targetBaseUrl + restUrlPath;
		return restTemplate.getForObject(url, String.class);
	}

	@Override
	public String post(String restUrlPath, String body) {
	    return restTemplate.postForObject(targetBaseUrl + restUrlPath, body, String.class);
	}
	
	@Override
	public <T> List<T> getList(String restUrlPath, Class<T> responseType) {
		String url = targetBaseUrl + restUrlPath;
		return restTemplate.getForObject(url, ArrayList.class);
	}
}
