package testapi.tests.booking.requests;

import  testapi.tests.booking.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostBookingRequest {
    BookingPayloads bookingPayloads= new BookingPayloads();

    @Step("Cria uma reserva  ")
    public Response PostBooking()
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
              //  .header("Cookie"  ,token )
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .post("booking");
    }

    @Step("Cria uma reserva  com campo extra payload")
    public Response PostExtraBooking()
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                //  .header("Cookie"  ,token )
                .when()
                .body(bookingPayloads.payloadExtraBooking().toString())
                .post("booking");
    }

    @Step("Cria uma reserva com payload invalido  ")
    public Response PostBookingPayloadInvalid()
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                //  .header("Cookie"  ,token )
                .when()
                .body(bookingPayloads.payloadInValidBooking().toString())
                .post("booking");
    }


    @Step("Cria uma reserva com Accept Invalido  ")
    public Response PostBookingAcceptInvalido()
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","Invalido")
                //  .header("Cookie"  ,token )
                .when()
                .body(bookingPayloads.payloadValidBooking().toString())
                .post("booking");
    }
}
