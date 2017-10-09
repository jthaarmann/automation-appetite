package com.jth.example.dashboard.service;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import mockit.Expectations;
import mockit.Mocked;

public class PortionsServiceImplTest5 {
	
	PortionsServiceImpl portionsService;
	
	@Mocked
	RestProxyService mockRestProxyService;
	
	@Before
	public void setUp(){
		portionsService = new PortionsServiceImpl();
		portionsService.restProxyService = mockRestProxyService;
	}
	
	//HERE IS AN EXAMPLE OF JMOCKIT Mocking
	@Test
	public void testGetChartData_returnsMap() {
		//given
		final String foodGroup = "Protien";
		new Expectations() {
			{
				mockRestProxyService.get("/entities/foodPortions/search/countByItemGroupName?group="+foodGroup);
				returns("12");
			}
		};
		
		//when
		Map<String, Object> chartData = portionsService.getChartData(foodGroup);
		
		//then
		assertEquals(foodGroup, chartData.get("items"));
		assertEquals(12L, chartData.get("value"));
	}


	@Test
	public void testGetChartDataVegetables_returnsMap() {
		//given
		final String day = "Protien";
		new Expectations() {
			{
				mockRestProxyService.get("/entities/foodPortions/search/countByDayAbbreviationAndItemGroupName?group=Vegetable&day="+day);
				returns("3");
			}
		};
		
		//when
		Map<String, Object> chartData = portionsService.getChartDataVegetables(day);
		
		//then
		assertEquals(day, chartData.get("items"));
		assertEquals(3L, chartData.get("value"));
	}
}
