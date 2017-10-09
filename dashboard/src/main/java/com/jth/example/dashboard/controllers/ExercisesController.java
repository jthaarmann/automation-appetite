package com.jth.example.dashboard.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jth.example.dashboard.service.ExerciseService;

@RestController
@RequestMapping("/exercises")
public class ExercisesController {

	@Autowired
	ExerciseService exerciseService;
	
	@RequestMapping(value="/chartDataByType", method = RequestMethod.GET)
	@ResponseBody public Map<String, List<Map<String, Object>>> chartDataByType(HttpServletRequest request) {
		return exerciseService.findChartDataByType();
	}
	
	@RequestMapping(value="/chartDataByDay", method = RequestMethod.GET)
	@ResponseBody public Map<String, List<Map<String, Object>>> chartDataByDay(HttpServletRequest request) {
		return exerciseService.findChartDataByDay();
	}
	
}
