package testapi.runners;

import  testapi.tests.booking.tests.GetBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory( testapi.suites.SchemaTest.class)
@Suite.SuiteClasses({
        GetBookingTest.class

})



public class SchemaTest {
}
