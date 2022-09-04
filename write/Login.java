package org.write;

import java.util.ArrayList;
import java.util.List;

import org.base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Login extends BaseClass {
	String logtoken;
	String AddressId;

	@Test(priority = 5)
	public void getUserAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);

		h.add(h1);
		h.add(h2);
		Headers headers = new Headers(h);

		addHeaders(headers);

		Response response = requestMethodType("GET","https://omrbranch.com/api/getUserAddress");
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify status Code");

		GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);

		String message = getUserAddress_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "OK","verify ok message");
	}

	@Test(priority = 4)
	public void deleteUserAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);

		addHeaders(headers);

		DeleteUserAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteUserAddress_Input_Pojo(AddressId);
		addBodyObj(deleteUserAddress_Input_Pojo);

		Response response = requestMethodType("DELETE", "https://omrbranch.com/api/deleteAddress");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		DeleteUserAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteUserAddress_Output_Pojo.class);

		String message = deleteUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address deleted successfully", "Verify Address deleted successfullye");

	}

	@Test(priority = 3)
	public void updateUserAddress() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);

		addHeaders(headers);

		UpdateUserAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateUserAddress_Input_Pojo(AddressId,
				"Neriyarasan", "Lenin", "9944484466", "L&T", 10, 20, 15, "600028", "chennai", "Home");

		addBodyObj(updateAddress_Input_Pojo);

		Response response = requestMethodType("PUT", "https://omrbranch.com/api/updateUserAddress");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		UpdateAddress_Output_Pojo updateAddress_Output_Pojo = response.as(UpdateAddress_Output_Pojo.class);

		String message = updateAddress_Output_Pojo.getMessage();
		System.out.println(message);

		Assert.assertEquals(message, "Address updated successfully", "verify update message");

	}

	@Test(priority = 2)
	public void userAddress() {

		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);

		addHeaders(headers);

		AddUserAddress_Input_Pojo addressInput = new AddUserAddress_Input_Pojo("Neriyarasan", "Lenin", "9944484466",
				"L&T", 10, 20, 15, "600028", "chennai", "Home");

		addBodyObj(addressInput);

		Response response = requestMethodType("POST", "https://omrbranch.com/api/addUserAddress");

		int status = getStatusCode(response);
		System.out.println(status);
		Assert.assertEquals(status, 200, "verify status code");

		AddAddress_Output_Pojo addAddress_Output_Pojo = response.as(AddAddress_Output_Pojo.class);
		String message = addAddress_Output_Pojo.getMessage();
		System.out.println(message);
		int address_id = addAddress_Output_Pojo.getAddress_id();
		AddressId = String.valueOf(address_id);

	}

	@Test(priority = 1)
	public void login() {

		addHeader("accept", "application/json");
		basicAuth("neriyarasan@gmail.com", "Neri@10392");

		Response response = requestMethodType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		Login_Output_Pojo loginOutput = response.as(Login_Output_Pojo.class);

		logtoken = loginOutput.getData().getLogtoken();

		// Assert.assertEquals(statusCode, 200, "verify status code");

		//
		// String first_name = loginOutput.getData().getFirst_name();
		// Assert.assertEquals(first_name, "Neriyarasan", "Verify firstName");

		// String pretty = response.asPrettyString();
		// System.out.println(pretty);
	}

}
