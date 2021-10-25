package testapi.utils;

public class Utils {
    public static String getSchemaBasePath(String pack, String nameSchema){
        return System.getProperty("user.dir")
        + "/src/test/java/testapi/tests/"
                +pack
                +"/schema/"
                +nameSchema
                +".json";
    }
}
//C:\Users\Angela\IdeaProjects\testApi\src\test\java\testapi\tests\booking\schema
//C:\Users\Angela\IdeaProjects\testApi\src\test\java\testapi\tests\booking\schema\bookings.json
//C:\Users\Angela\IdeaProjects\cwi.testapi\src\test\java\br\com\cwi\testapi\tests\booking\schema