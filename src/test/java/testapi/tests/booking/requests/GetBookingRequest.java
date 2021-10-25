package testapi.tests.booking.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {
    @Step("Retornar os ids das listagagem de reservas ")
    public Response bookingReturnIds(){
        return given()
                .when()
                .get("booking");

    }

    @Step("Listagem das reservas")
    public Response bookingReturnIds(String filtro, String valorfiltro){
        return given()
                .queryParams(filtro,valorfiltro)
                .when()
                .log().all()
                .get("booking");
    }

    @Step("Listagem das reservas")
    public Response bookingReturnEspecifcBoooking(int idbooking){
        return given()
                .when()
                .log().all()
                .get("booking/"+ idbooking);
    }

    @Step("Listagem das reservas")
    public Response bookingReturnIds(String filtro, String valorfiltro,String filtro2, String valorfiltro2){
        return given()
                .queryParams(filtro,valorfiltro,filtro2,valorfiltro2)
                .when()
                .log().all()
                .get("booking");
    }


    @Step("Listagem das reservas")
    public Response bookingReturnIds(String filtro, String valorfiltro,String filtro2, String valorfiltro2,String filtro3, String valorfiltro3){
        return given()
                .queryParams(filtro,valorfiltro,filtro2,valorfiltro2,filtro3,valorfiltro3)
                .when()
                .log().all()
                .get("booking");
    }
}
