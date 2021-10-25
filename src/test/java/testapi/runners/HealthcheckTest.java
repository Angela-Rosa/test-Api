package testapi.runners;

import  testapi.tests.ping.tests.GetPingTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory( testapi.suites.HealthcheckTest.class)
@Suite.SuiteClasses({
        GetPingTest.class

})


public class HealthcheckTest {
}
