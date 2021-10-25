package testapi.runners;

import  testapi.tests.booking.tests.DeleteBookingTest;
import  testapi.tests.booking.tests.PostBookingTest;
import  testapi.tests.booking.tests.PutBookingTest;
import  testapi.tests.ping.tests.GetPingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory( testapi.suites.E2e.class)
@Suite.SuiteClasses({
        PostBookingTest.class,
        PutBookingTest.class,
        GetPingTest.class,
        DeleteBookingTest.class

})


public class E2eTest {
}
