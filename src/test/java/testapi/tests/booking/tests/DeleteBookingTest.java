package testapi.tests.booking.tests;

import  testapi.base.BaseTest;
import  testapi.suites.AcceptanceTest;
import  testapi.suites.AllTests;
import  testapi.suites.E2e;
import  testapi.tests.auth.request.PostAuthRequests;
import  testapi.tests.booking.requests.DeleteBookingRequest;
import  testapi.tests.booking.requests.GetBookingRequest;
import  testapi.tests.booking.requests.PutBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Exclusão de reserva")
public class DeleteBookingTest extends BaseTest {

    DeleteBookingRequest deleteBookingRequest = new DeleteBookingRequest();
    GetBookingRequest getBookingRequest= new GetBookingRequest();
    PostAuthRequests postAuthRequests= new PostAuthRequests();



    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Remover uma reserva  utilizando o token")
    public void ValidarExclusaoUmaReservaUtilizandoToken() {
        int primeiroId= getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        deleteBookingRequest.DeleteBookingToken(primeiroId,postAuthRequests.getToken() )
                .then()
                .statusCode(201);
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2e.class})
    @DisplayName("Remover uma reserva  sem  o token")
    public void ValidarExclusaoUmaReservaSemToken() {
        int primeiroId= getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        deleteBookingRequest.DeleteBookingSemToken(primeiroId )
                .then()
                .statusCode(403);
    }



    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class,E2e.class})
    @DisplayName("Remover uma reserva  que nao existe")
    public void ValidarExclusaoUmaReservaQueNaoExiste() {

        deleteBookingRequest.DeleteBookingToken(98271292,postAuthRequests.getToken() )
                .then()
                .statusCode(405);
    }

}
