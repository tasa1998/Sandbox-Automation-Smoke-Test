package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Test
@CucumberOptions(
        features = {"src/test/java/features/Homeowner.feature","src/test/java/features/PersonalAuto.feature"},
        glue= "steps",
        tags="@Smoke"
)
public class SmokeTestNgRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
