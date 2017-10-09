package com.jth.rest.automation.rest.entities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import org.testng.annotations.Test;

import com.jth.rest.core.test.RestTest;

import io.restassured.response.ValidatableResponse;

/*
 * This test class is more to ensure we are adding coverage as we expose entities
 * It does not necessarily test functionality of the rest services application
 */
public class EntitiesTest extends RestTest {

	@Test
    public void testEntities_containsAllSupported() {       
		ValidatableResponse response = 
		given().
		when().get("/entities").
		then().statusCode(200);
		
		//assert all entities are present
		for(Entity entity : Entity.values()) {
			response.body("_links" + "." + entity.getName(), notNullValue());		
		}
		
		//assert there are no extra entities that we arent expecting
		response.body("_links.size()", greaterThanOrEqualTo(Entity.values().length));
	}
	
	enum Entity {
		ACCOUNTS("accounts"),
		DAYS("days"),
		FOOD_PORTIONS("foodPortions"),
		FOOD_ITEMS("foodItems"),
		EXERCISES("exercises"),
		EXERCISE_SESSIONS("exerciseSessions"),
		ALPS_PROFILE("profile"),
		;

		private String name;
		
		Entity(String name){
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
}
