package testapi.tests.booking.requests;

import  testapi.tests.booking.payloads.BookingPayloads;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookingRequest {
    BookingPayloads bookingPayloads= new BookingPayloads();

    @Step("Remove uma reserva especifica com o paramentro token")
    public Response DeleteBookingToken(int id, String token)
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("Cookie"  ,token )
                .when()
                .delete("booking/"+ id);
    }

    @Step("Remove uma reserva especifica sem  o paramentro token")
    public Response DeleteBookingSemToken(int id)
    {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .when()
                .delete("booking/"+ id);
    }
}
