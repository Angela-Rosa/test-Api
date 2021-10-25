package testapi.tests.ping.tests;

import  testapi.base.BaseTest;
import  testapi.suites.AllTests;
import  testapi.suites.HealthcheckTest;
import  testapi.tests.ping.requests.GetPingRequests;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Feature("Feature - Api Online")
public class GetPingTest extends BaseTest {
    GetPingRequests getPingRequests= new GetPingRequests();

    @Test
    @Severity(SeverityLevel.BLOCKER)
   @Category({AllTests.class, HealthcheckTest.class})
    @DisplayName("Verificar se a api esta online")
    public void validaApiOnline(){
        getPingRequests.pingReturnApi()
                .then()
                .statusCode(201);

    }


    }




