package testapi.tests.ping.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;



public class GetPingRequests {

    @Step("Retorna a api online")
    public Response pingReturnApi(){
        return given()
                .header("Content-Type", "application/json")
                .get("ping");
    }
}
