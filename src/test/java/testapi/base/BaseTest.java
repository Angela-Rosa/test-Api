package testapi.base;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static  void Setup(){
        RestAssured.baseURI="https://treinamento-api.herokuapp.com/";
    }

}
