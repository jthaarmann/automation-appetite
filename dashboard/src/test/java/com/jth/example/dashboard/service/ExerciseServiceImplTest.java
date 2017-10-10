package com.jth.example.dashboard.service;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;

public class ExerciseServiceImplTest {
	
	ExerciseServiceImpl exerciseService;
	
	@Mocked
	RestProxyService mockRestProxyService;
	
	@Before
	public void setUp(){
		exerciseService = new ExerciseServiceImpl();
		exerciseService.restProxyService = mockRestProxyService;
	}
	
	//HERE IS AN EXAMPLE OF JMOCKIT Mocking
	@Test
	public void testGetChartData_returnsMap() {
		//given
		final String day = "W";
		new Expectations() {
			{
				mockRestProxyService.get("/entities/exerciseSessions/search/countByDayAbbreviation?day="+day);
				returns("15");
			}
		};
		
		//when
		Map<String, Object> chartData = exerciseService.getChartData(day);
		
		//then
		assertEquals(day, chartData.get("items"));
		assertEquals(15L, chartData.get("value"));
	}

}
