import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\HannasWorkshop\\src\\test\\resources\\features",
        glue = "steps")

public class TestRunner {

//    @Before
//    public void beforeTest() {
//        instance = WebDriverSingletoneInstance.getWebDriverSingletoneInstance();
//    }
//
//    @After
//    public void closeDriver() {
//        instance.closeDriver();
//    }
}
