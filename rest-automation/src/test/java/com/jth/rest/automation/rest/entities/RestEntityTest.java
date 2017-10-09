package com.jth.rest.automation.rest.entities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import org.testng.annotations.Test;

import com.jth.rest.core.test.RestTest;

import io.restassured.response.ValidatableResponse;

public abstract class RestEntityTest extends RestTest{
	
	public abstract String getEntityName();	
	
	public abstract String getHighestId();	
	
	public abstract String getLowestId();
	
	
	@Test
    public void testPage_customPage() {
		Integer pageNumber = 3;
		ValidatableResponse response = 
		given().
		when().get("/entities/"+getEntityName()+"?page=" + pageNumber).
		then().statusCode(200);
		
		//assert there are no extra entities that we arent expecting
		response.body("page.number", is(3));
	}
	
	@Test
    public void testSort_customSortAscending() {
		String ascending = "asc";
		ValidatableResponse response = 
		given().
		when().get("/entities/"+getEntityName()+"?sort=id," + ascending).
		then().statusCode(200);
		
		//assert there are no extra entities that we arent expecting
		response.body("_embedded."+getEntityName()+"[0].id", is(Integer.parseInt(getLowestId())));
	}
	
	@Test
    public void testSort_customSortDescending() {
		String descending = "desc";
		ValidatableResponse response = 
		given().
		when().get("/entities/"+getEntityName()+"?sort=id," + descending).
		then().statusCode(200);
		
		//assert there are no extra entities that we arent expecting
		response.body("_embedded."+getEntityName()+"[0].id", greaterThanOrEqualTo(Integer.parseInt(getHighestId())));
	}
	
	@Test
    public void test_byInvalidId() {
		Integer id = 9999999;
		given().
		when().get("/entities/"+getEntityName()+"/" + id).
		then().statusCode(404);
	}
	

	

}
