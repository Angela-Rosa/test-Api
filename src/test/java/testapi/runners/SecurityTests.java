package testapi.runners;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory( testapi.suites.SecurityTests.class)
@Suite.SuiteClasses({


})
public class SecurityTests {
}
