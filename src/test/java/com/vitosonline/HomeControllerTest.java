package com.vitosonline;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@EnableAutoConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HomeControllerTest {

        @LocalServerPort
        private int port;

        @BeforeEach
        public void setUp() {
            RestAssured.port = port;
        }

        @Test
        public void testGetCategory() {
            given()
                    .when()
                    .get("/api/pizza/get-all-cat")
                    .then()
                    .statusCode(200)
                    .body("size()", is(greaterThanOrEqualTo(0)));

        }

    @Test
    public void testGetPizza() {
        given()
                .when()
                .get("/api/pizza/2/get-all-pizza")
                .then()
                .statusCode(200);
    }

}
