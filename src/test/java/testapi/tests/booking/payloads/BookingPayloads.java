package testapi.tests.booking.payloads;
import org.json.JSONObject;
import io.restassured.response.Response;

public class BookingPayloads {

    public  static  JSONObject payloadValidBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2018-07-10");
        bookingDates.put("checkout","2019-05-14");

        payload.put("firstname","JuliaAR");
        payload.put("lastname", "da silva");
        payload.put("totalprice" , 111);
        payload.put("depositpaid" , true);
        payload.put("bookingdates" , bookingDates);
        payload.put("additionalneeds" , "Breakfast");

        return payload;
    }


    public  static  JSONObject payloadInValidBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("invalido","2018-07-10");
        bookingDates.put("invalid","2019-05-14");

        payload.put("firstname","JuliaAR");
        payload.put("lastname", "da silva");
        payload.put("totalprice" , 111);
        payload.put("depositpaid" , true);
        payload.put("bookingdates" , bookingDates);
        payload.put("additionalneeds" , "Breakfast");

        return payload;
    }

    public  static  JSONObject payloadExtraBooking(){
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();

        bookingDates.put("checkin","2018-07-10");
        bookingDates.put("checkout","2019-05-14");

        payload.put("firstname","JuliaAR");
        payload.put("lastname", "da silva");
        payload.put("totalprice" , 111);
        payload.put("depositpaid" , true);
        payload.put("bookingdates" , bookingDates);
        payload.put("additionalneeds" , "Breakfast");

        payload.put("extra" , "extraPayloads");

        return payload;
    }

}
