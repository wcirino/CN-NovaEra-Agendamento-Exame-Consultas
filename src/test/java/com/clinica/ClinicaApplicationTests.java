package com.clinica;

import org.springframework.boot.test.context.SpringBootTest;
//import static io.restassured.RestAssured.given;
/*import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;*/

//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClinicaApplicationTests {
	/*
	 * @LocalServerPort private int port;
	 * 
	 * 
	 * @Test void contextLoads() { assertFalse(Boolean.FALSE); }
	 * 
	 * @BeforeEach public void setUp() {
	 * RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	 * RestAssured.port = port; RestAssured.basePath = "/api-agendamento"; }
	 * 
	 * 
	 * @Test public void deveBuscarConsultasAgendamentoHTTP200_ID() {
	 * given().accept(ContentType.JSON).when().get("/agendamento-id/2").then().
	 * statusCode(HttpStatus.OK.value()); }
	 */ 
}
