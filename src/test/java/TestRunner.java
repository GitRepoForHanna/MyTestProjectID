import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\HannasWorkshop\\src\\test\\resources\\features",
        glue = "steps",
        plugin = {"pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"},
        tags = "@ForRun")

public class TestRunner {

//    public static void main(String[] args) {
//        System.out.println("Main class in Test Runner");
//        JUnitCore junitCore = new JUnitCore();
//        junitCore.addListener(new ScreenShotListener());
//        junitCore.run();
//    }

}
