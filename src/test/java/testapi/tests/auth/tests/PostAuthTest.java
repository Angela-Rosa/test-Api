package testapi.tests.auth.tests;

import  testapi.base.BaseTest;
import  testapi.suites.AllTests;
import  testapi.suites.SmokeTests;
import  testapi.tests.auth.request.PostAuthRequests;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import  static org.hamcrest.CoreMatchers.notNullValue;

@Feature("Feature de Autenticação")
public class PostAuthTest extends BaseTest {
    PostAuthRequests postAuthRequest= new PostAuthRequests();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllTests.class, SmokeTests.class})
    @DisplayName("Retorna token para o usuario")
    public void validaRetornoTokenUsuario(){
        postAuthRequest.tokenReturn()
                .then()
                .statusCode(200)
                .body("token",notNullValue());
    }
}

