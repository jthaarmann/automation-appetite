package com.jth.rest.automation.rest.entities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

public class AccountsTest extends RestEntityTest {

	enum Field {
		ID("id"), 
		NAME("name"), 
		DESCRIPTION("description");

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
		Integer id = 1;

		given().pathParam("id", id).when().get("/entities/accounts/{id}").then().statusCode(200);
	}

	@Test
	public void testGet_byId_resonseContainsAllFields() {
		Integer id = 1;
		String description = "this is a test decription";
		String name = "testing";

		given().
		when().get("/entities/accounts/" + id).
		then()
			.statusCode(200)
			.body(Field.ID.getName(), equalTo(id))
			.body(Field.NAME.getName(), equalTo(name))
			.body(Field.DESCRIPTION.getName(), equalTo(description));
	}

	@Test
	public void testInsertAndDelete() throws InterruptedException {
		String jsonPayload = "{ \"id\": \"499111\", \"name\": \"test\", \"description\": \"test\" }";

		ValidatableResponse response = 
		given().
			contentType("application/json").
			body(jsonPayload).
		when().post("/entities/accounts").
		then().
			statusCode(201);

		String id = response.extract().path("id").toString();

		given().pathParam("id", id).
		when().get("/entities/accounts/{id}").
		then().
			statusCode(200); //create new record

		given().pathParam("id", id).
		when().delete("/entities/accounts/{id}").
		then().statusCode(204); //delete new record

		given().pathParam("id", id).
		when().get("/entities/accounts/{id}").
		then().statusCode(404); // assert no longer found
	}

	@Test
	public void testUpdate() {
		String id = "1";
		String name = "testing";
		String description = "this is a test decription";
		String jsonPayload = "{ \"id\": \"" + id + "\", \"name\": \""+ name + "\", \"description\": \"" + description + "\" }";
		
		String newName = "new name";
		String newDescription = "new desc";
		String newJsonPayload = "{ \"id\": \"" + id	+ "\", \"name\": \""+ newName + "\", \"description\": \"" + newDescription + "\" }";

		given().
			pathParam("id", id).
			contentType("application/json").
			body(newJsonPayload).
		when().put("/entities/accounts/{id}").
		then()
			.statusCode(200);

		given().
			pathParam("id", id).
		when().get("/entities/accounts/{id}").
		then().
			statusCode(200).
			body("name", is(newName)).
			body("description", is(newDescription));

		given().
			pathParam("id", id).
			contentType("application/json").
			body(jsonPayload).
		when().put("/entities/accounts/{id}").
		then()
			.statusCode(200);
	}

	@Override
	public String getEntityName() {
		return "accounts";
	}

	@Override
	public String getHighestId() {
		return "1";
	}

	@Override
	public String getLowestId() {
		return "1";
	}

}
