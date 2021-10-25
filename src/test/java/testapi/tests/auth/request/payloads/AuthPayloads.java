package testapi.tests.auth.request.payloads;
import org.json.JSONObject;
import io.restassured.response.Response;

public class AuthPayloads {

    public  JSONObject jsonAuthLogin(){
        JSONObject payload= new JSONObject();
        payload.put("username","admin");
        payload.put("password","password123");
return payload;
    }
}
