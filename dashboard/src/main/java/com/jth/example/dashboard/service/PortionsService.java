package com.jth.example.dashboard.service;

import java.util.List;
import java.util.Map;


public interface PortionsService {

	Map<String, List<Map<String, Object>>> findChartDataByFoodGroups();

	Map<String, List<Map<String, Object>>> findChartDataVegetablesByDay();
	
}