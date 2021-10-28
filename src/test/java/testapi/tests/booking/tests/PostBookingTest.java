package testapi.tests.booking.tests;

import  testapi.base.BaseTest;
import  testapi.suites.AcceptanceTest;
import  testapi.suites.AllTests;
import  testapi.suites.E2e;
import  testapi.tests.auth.request.PostAuthRequests;
import  testapi.tests.booking.payloads.BookingPayloads;
import  testapi.tests.booking.requests.GetBookingRequest;
import  testapi.tests.booking.requests.PostBookingRequest;
import  testapi.tests.booking.requests.PutBookingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
@Feature("Feature - Criar de reservas")
public class PostBookingTest extends BaseTest {
    PostBookingRequest postBookingRequest = new PostBookingRequest();
    GetBookingRequest getBookingRequest= new GetBookingRequest();
    PostAuthRequests postAuthRequests= new PostAuthRequests();
    BookingPayloads bookingPayloads= new BookingPayloads();



    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, AcceptanceTest.class})
    @DisplayName("Criar uma nova reserva ")
    public void ValidarCriarUmaReserva() {
        postBookingRequest.PostBooking(  )
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("booking.firstname", equalTo("JuliaAR"));
    }



    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2e.class})
    @DisplayName("Validar Criar  mais de uma nova reserva em sequencia ")
    public void ValidarCriarMaisUmaReservaSequencia() {

        postBookingRequest.PostBooking(  )
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("booking.firstname", equalTo("JuliaAR"));

        postBookingRequest.PostBooking(  )
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .body("booking.firstname", equalTo("JuliaAR"));

    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class, E2e.class})
    @DisplayName("Criar uma reserva enviando payload inválido ")
    public void ValidarCriarUmaReservaComPayloadInvalido() {
        postBookingRequest.PostBookingPayloadInvalid(  )
                .then()
                .statusCode(500);
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class,E2e.class})
    @DisplayName("Validar retorno 418 quando o header Accept for inválido ")
    public void ValidarCriarUmaReservaAcceptInvalido() {
        postBookingRequest.PostBookingAcceptInvalido(  )
                .then()
                .statusCode(418);
    }
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category({AllTests.class})
    @DisplayName("Criar uma reserva enviando mais parâmetros no payload da reserva")
    //Bug na API- Não seria possivel criar, mas api permitiu criar mais parametros
    public void ValidarCriarUmaReservaExtraPayload() {
        postBookingRequest.PostExtraBooking()
                .then()
                .statusCode(400);
    }


}
