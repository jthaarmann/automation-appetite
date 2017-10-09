package com.jth.example.dashboard.service;

import java.util.List;

public interface RestProxyService {

	String post(String restUrlPath, String body);

	String get(String restUrlPath);

	<T> List<T> getList(String restUrlPath, Class<T> responseType);

}
