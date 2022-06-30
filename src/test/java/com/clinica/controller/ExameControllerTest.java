package com.clinica.controller;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExameControllerTest {

	/*
	 * @LocalServerPort private int port;
	 * 
	 * @Test void contextLoads() { assertFalse(Boolean.FALSE); }
	 */

	/*
	 * @BeforeEach public void setUp() {
	 * RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	 * RestAssured.port = port; RestAssured.basePath = "/api-exame"; }
	 * 
	 * @Test public void deveBuscarExameSucesso() {
	 * given().accept(ContentType.JSON).when().get("/exame-id/2").then().statusCode(
	 * HttpStatus.OK.value()); }
	 * 
	 * @Test public void deveBuscarTodosOsExamesSucess() {
	 * given().accept(ContentType.JSON).when().get("/exame").then().statusCode(
	 * HttpStatus.OK.value()); }
	 * 
	 */
}
