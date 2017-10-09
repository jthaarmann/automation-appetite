package com.jth.example.dashboard.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortionsServiceImpl implements PortionsService {

	@Autowired
	RestProxyService restProxyService;
	
	@Override
	public Map<String, List<Map<String, Object>>> findChartDataByFoodGroups() {
		Map<String, List<Map<String, Object>>> chart = new HashMap<String, List<Map<String, Object>>>();
		List<Map<String, Object>> chartData = new ArrayList<Map<String, Object>>();  
		for(String foodGroup : findFoodGroups()) {
			chartData.add(getChartData(foodGroup));
		}
		chart.put("chartData", chartData);
		return chart;
	}
	
	@Override
	public Map<String, List<Map<String, Object>>> findChartDataVegetablesByDay() {
		Map<String, List<Map<String, Object>>> chart = new HashMap<String, List<Map<String, Object>>>();
		List<Map<String, Object>> chartData = new ArrayList<Map<String, Object>>();  
		for(String day : findDays()) {
			chartData.add(getChartDataVegetables(day));
		}
		chart.put("chartData", chartData);
		return chart;
	}

	protected Map<String, Object> getChartData(String foodGroup) {
		Map<String, Object> chartDataEntry = new HashMap<String, Object>();
		chartDataEntry.put("items", foodGroup);
		chartDataEntry.put("value", findCount(foodGroup));
		return chartDataEntry;
	}
	
	protected Map<String, Object> getChartDataVegetables(String day) {
		Map<String, Object> chartDataEntry = new HashMap<String, Object>();
		chartDataEntry.put("items", day);
		chartDataEntry.put("value", findCountVegetables(day));
		return chartDataEntry;
	}

	private long findCountVegetables(String day) {
		return Long.parseLong(restProxyService.get("/entities/foodPortions/search/countByDayAbbreviationAndItemGroupName?group=Vegetable&day="+day));
	}
	
	private long findCount(String foodGroup) {
		return Long.parseLong(restProxyService.get("/entities/foodPortions/search/countByItemGroupName?group="+foodGroup));
	}

	private List<String> findFoodGroups() {
		List<String> foodGroups = new ArrayList<String>();
		foodGroups.add("Fruit");
		foodGroups.add("Vegetable");
		foodGroups.add("Grain");
		foodGroups.add("Protein");
		foodGroups.add("Other");
		return foodGroups;
	}
	
	private List<String> findDays() {
		List<String> days = new ArrayList<String>();
		days.add("Su");
		days.add("M");
		days.add("Tu");
		days.add("W");
		days.add("Th");
		days.add("F");
		days.add("Sa");
		return days;
	}
}
