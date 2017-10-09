package com.jth.example.dashboard.service;

import java.util.List;
import java.util.Map;

public interface ExerciseService {

	Map<String, List<Map<String, Object>>> findChartDataByType();

	Map<String, List<Map<String, Object>>> findChartDataByDay();
}
