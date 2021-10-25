package testapi.tests.booking.tests;

import  testapi.base.BaseTest;
import  testapi.suites.*;
import  testapi.tests.booking.requests.GetBookingRequest;
import  testapi.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Feature - Retorno de Reservas")
public class GetBookingTest extends BaseTest {
    GetBookingRequest getBookingRequest= new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas")
    public void validaListaIdsDasReservas() {
        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }



    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class, SchemaTest.class})
    @DisplayName("Garantir o Schema de returno de listagem de reservas")
    public void validaSchemaListaDaReserva(){
        getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "bookings"))));
    }


    //////////////////////// ATIVIDADE/////////////////////


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, ContractTests.class,SchemaTest.class})
    @DisplayName("Garantir o Schema de returno de listagem de reservas")
    public void validaSchemaDeUmaDaReserva(){
        int primeiroId= getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.bookingReturnEspecifcBoooking(primeiroId)
                .then()
                .statusCode(200)
                .body(matchesJsonSchema(new File(Utils.getSchemaBasePath("booking", "booking"))));
    }



    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Validar  lista um booking especifico")
    public void validaListaBookingEspecifico() {

        int primeiroId= getBookingRequest.bookingReturnIds()
                .then()
                .statusCode(200)
                .extract()
                .path("[0].bookingid");

        getBookingRequest.bookingReturnEspecifcBoooking(primeiroId)
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, E2e.class})
    @DisplayName("Listar os IDs de reservas Por filtro invalido ") // BUG NA API
    public void validaListaIdsDasReservasPorFiltroInvalido() {
        getBookingRequest.bookingReturnIds("XXXXX", "JuliaAR")
                .then()
                .statusCode(500)
                .body("size()", greaterThan(0));
        // .body("[0].bookingid", equalTo(18));
    }



    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName(" Lista os ids das reservas por first name ")
    public void validaListaIdsDasReservasPorFisrtName() {

        getBookingRequest.bookingReturnIds("firstname", "JuliaAR")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
               // .body("[0].bookingid", equalTo(18));
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas Por LastName")
    public void validaListaIdsDasReservasPorLastName() {

        getBookingRequest.bookingReturnIds("lastname", "da silva")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
                //.body("[0].bookingid", equalTo(18));
    }


    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas Por Chekin")
    public void validaListaIdsDasReservasPorChekin() {

        getBookingRequest.bookingReturnIds("checkin", "2018-07-10")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
//                .body("[0].bookingid", equalTo(18));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas Por Checkout")
    public void validaListaIdsDasReservasPorCheckout() {
        getBookingRequest.bookingReturnIds("checkout", "2019-05-14")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
  //              .body("[0].bookingid", equalTo(18));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas Por Chekin e Checkout")
    public void validaListaIdsDasReservasPorChekinCheckout() {
        getBookingRequest.bookingReturnIds("checkin", "2018-07-10","checkout", "2019-05-14")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
//                .body("[0].bookingid", equalTo(18));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class,AcceptanceTest.class})
    @DisplayName("Listar os IDs de reservas Por FisrtName, Chekin e Checkout")
    public void validaListaIdsDasReservasPorFisrtNameChekinCheckout() {
        getBookingRequest.bookingReturnIds("firstname", "JuliaAR","checkin", "2018-07-10","checkout", "2019-05-14")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0));
  //              .body("[0].bookingid", equalTo(18));
    }

}
