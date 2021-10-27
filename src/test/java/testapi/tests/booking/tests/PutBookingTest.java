package testapi.tests.booking.tests;

import  testapi.base.BaseTest;
import  testapi.suites.AcceptanceTest;
import  testapi.suites.AllTests;
import  testapi.suites.E2e;
import  testapi.tests.auth.request.PostAuthRequests;
import  testapi.tests.booking.requests.GetBookingRequest;
import  testapi.tests.booking.requests.PutBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Atualização de Reservas")
public class PutBookingTest extends BaseTest {
    PutBookingRequest putBookingRequest = new PutBookingRequest();
    GetBookingRequest getBookingRequest= new GetBookingRequest();
 PostAuthRequests postAuthRequests= new PostAuthRequests();


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Alterar uma reserva somente utilizando o token")
    public void ValidarAlteracaoUmaReservaUtilizandoToken() {
    int primeiroId= getBookingRequest.bookingReturnIds()
            .then()
            .statusCode(200)
            .extract()
            .path("[0].bookingid");

    putBookingRequest.updateBookingToken(primeiroId,postAuthRequests.getToken() )
            .then()
            .statusCode(200)
            .body("size()", greaterThan(0));

    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2e.class})
    @DisplayName("Alterar uma reserva  utilizando o token invalido") //Bug na API- Houve falha na autenticação do tipo basic auth.
    public void ValidarAlteracaoUmaReservaTokenInvalido() {
        int primeiroId= getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingToken(primeiroId,"TOken invalido" )
                .then()
                .statusCode(403);
    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class,E2e.class})
    @DisplayName("Alterar  uma reserva que nao existe")
    public void ValidarAlteracaoUmaReservaNaoExiste() {

        putBookingRequest.updateBookingToken(12321312,postAuthRequests.getToken() )
                .then()
                .statusCode(405);
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class,E2e.class})
    @DisplayName("Alterar uma reserva sem o token")
    public void ValidarAlteracaoUmaReservaSemToken() {
        int primeiroId= getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingSemToken(primeiroId )
                .then()
                .statusCode(403);

    }


    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Alterar uma reserva utilizando o Basic User")
    public void ValidarAlteracaoUmaReservaUtilizandoBasic() {
        int primeiroId= getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        putBookingRequest.updateBookingBasicAuth(primeiroId )
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));

    }
}

