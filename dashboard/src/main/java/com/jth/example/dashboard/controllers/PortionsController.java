package com.jth.example.dashboard.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jth.example.dashboard.service.PortionsService;

@RestController
@RequestMapping("/portions")
public class PortionsController {

	@Autowired
	PortionsService portionsService;
	
	@RequestMapping(value="/chartDataByFoodGroups", method = RequestMethod.GET)
	@ResponseBody public Map<String, List<Map<String, Object>>> chartDataByFoodGroups(HttpServletRequest request) {
		return portionsService.findChartDataByFoodGroups();
	}
	
	@RequestMapping(value="/chartDataVegetablesByDay", method = RequestMethod.GET)
	@ResponseBody public Map<String, List<Map<String, Object>>> chartDataVegetablesByDay(HttpServletRequest request) {
		return portionsService.findChartDataVegetablesByDay();
	}
}