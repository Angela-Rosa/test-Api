package testapi.runners;

import  testapi.tests.auth.tests.PostAuthTest;
import  testapi.tests.booking.tests.GetBookingTest;
import  testapi.tests.booking.tests.PutBookingTest;
import  testapi.tests.ping.tests.GetPingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory( testapi.suites.AllTests.class)
@Suite.SuiteClasses({
        GetPingTest.class,
        GetBookingTest.class,
        PostAuthTest.class,
        PutBookingTest.class

})




public class AllTests {

}
