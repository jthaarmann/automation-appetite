package com.jth.rest.automation.rest.entities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

public class Exercises extends RestEntityTest {

	enum Field {
		ID("id"), 
		NAME("name"), 
		TYPE("exerciseType.type");

		private String name;

		Field(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	@Test
	public void testGet_byId() {
		Integer id = 3;

		given().pathParam("id", id).
		when().get("/entities/exercises/{id}").
		then().statusCode(200);
	}

	@Test
	public void testGet_byId_resonseContainsAllFields() {
		Integer id = 3;
		String name = "Cycling";
		String type = "E";

		given().
		when().get("/entities/exercises/" + id).
		then()
			.statusCode(200)
			.body(Field.ID.getName(), equalTo(id))
			.body(Field.NAME.getName(), equalTo(name))
			.body(Field.TYPE.getName(), equalTo(type));
	}

	@Test
	public void testInsertAndDelete() throws InterruptedException {
		String jsonPayload = "{ \"id\": \"7865334\", \"name\": \"test\", \"exerciseType\": { \"type\": \"E\" } }";

		ValidatableResponse response = 
		given().
			contentType("application/json").
			body(jsonPayload).
		when().post("/entities/exercises").
		then().
			statusCode(201);

		String id = response.extract().path("id").toString();

		given().pathParam("id", id).
		when().get("/entities/exercises/{id}").
		then().
			statusCode(200); //create new record

		given().pathParam("id", id).
		when().delete("/entities/exercises/{id}").
		then().statusCode(204); //delete new record

		given().pathParam("id", id).
		when().get("/entities/exercises/{id}").
		then().statusCode(404); // assert no longer found
	}

	@Test
	public void testUpdate() {
		String id = "3";
		String name = "Cycling";
		String jsonPayload = "{ \"id\": \"" + id + "\", \"name\": \""+ name + "\" }";
		
		String newName = "testing";
		String newJsonPayload = "{ \"id\": \"" + id + "\", \"name\": \""+ newName + "\" }";

		given().
			pathParam("id", id).
			contentType("application/json").
			body(newJsonPayload).
		when().put("/entities/exercises/{id}").
		then()
			.statusCode(200);

		given().
			pathParam("id", id).
		when().get("/entities/exercises/{id}").
		then().
			statusCode(200).
			body("name", is(newName));

		given().
			pathParam("id", id).
			contentType("application/json").
			body(jsonPayload).
		when().put("/entities/exercises/{id}").
		then()
			.statusCode(200);
	}

	@Override
	public String getEntityName() {
		return "exercises";
	}

	@Override
	public String getHighestId() {
		return "15";
	}

	@Override
	public String getLowestId() {
		return "1";
	}

}
