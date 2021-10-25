package testapi.runners;

import testapi.tests.auth.tests.PostAuthTest;
import  testapi.tests.booking.tests.DeleteBookingTest;
import  testapi.tests.booking.tests.GetBookingTest;
import  testapi.tests.booking.tests.PostBookingTest;
import  testapi.tests.booking.tests.PutBookingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory( testapi.suites.AcceptanceTest.class)
@Suite.SuiteClasses({

        PostBookingTest.class,
        PutBookingTest.class,
        GetBookingTest.class,
        DeleteBookingTest.class

})
public class AcceptanceTest {
}
