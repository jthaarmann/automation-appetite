package com.jth.example.dashboard.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {

	@Autowired
	RestProxyService restProxyService;
	
	@Override
	public Map<String, List<Map<String, Object>>> findChartDataByType() {
		Map<String, List<Map<String, Object>>> chart = new HashMap<String, List<Map<String, Object>>>();
		List<Map<String, Object>> chartData = new ArrayList<Map<String, Object>>();  
		Map<String, String> exerciseTypes = findExerciseTypes();
		for(Entry<String, String> type : exerciseTypes.entrySet()) {
			chartData.add(getChartData(type));
		}
		chart.put("chartData", chartData);
		return chart;
	}

	@Override
	public Map<String, List<Map<String, Object>>> findChartDataByDay() {
		Map<String, List<Map<String, Object>>> chart = new HashMap<String, List<Map<String, Object>>>();
		List<Map<String, Object>> chartData = new ArrayList<Map<String, Object>>();  
		for(String day : findDays()) {
			chartData.add(getChartData(day));
		}
		chart.put("chartData", chartData);
		return chart;
	}

	protected Map<String, Object> getChartData(Entry<String, String> type) {
		Map<String, Object> chartDataEntry = new HashMap<String, Object>();
		chartDataEntry.put("items", type.getValue());
		chartDataEntry.put("value", findCount(type.getKey()));
		return chartDataEntry;
	}

	protected Map<String, Object> getChartData(String day) {
		Map<String, Object> chartDataEntry = new HashMap<String, Object>();
		chartDataEntry.put("items", day);
		chartDataEntry.put("value", findCountByDay(day));
		return chartDataEntry;
	}


	private long findCount(String type) {
		return Long.parseLong(restProxyService.get("/entities/exerciseSessions/search/countByExerciseExerciseTypeType?type="+type));
	}
	
	private long findCountByDay(String day) {
		return Long.parseLong(restProxyService.get("/entities/exerciseSessions/search/countByDayAbbreviation?day="+day));
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
	
	private Map<String, String> findExerciseTypes() {
		Map<String, String> exerciseTypes = new HashMap<String, String>();
		exerciseTypes.put("S", "Strength");
		exerciseTypes.put("E", "Endurance");
		exerciseTypes.put("F", "Flexibility");
		exerciseTypes.put("B", "Balance");
		return exerciseTypes;
	}
}
