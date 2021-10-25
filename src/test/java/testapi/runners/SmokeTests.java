package testapi.runners;

import  testapi.tests.auth.tests.PostAuthTest;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory( testapi.suites.SmokeTests.class)
@Suite.SuiteClasses({

})
public class SmokeTests {
}
