package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import tech.dock.test.core.listener.DefaultListener;
import tech.dock.test.data.listener.DataListener;

@CucumberOptions(
            features = "src/test/resources/feature",
            tags = "@AllScenarios",
            glue = {"steps"},
            plugin = {"json:target/jsonReport/CucumberTestReport.json",
                    "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm",
            },
            monochrome = true,
            dryRun = false,
            strict = true

    )
    @Listeners({DataListener.class, DefaultListener.class})
    public class Runners extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios() {
            return super.scenarios();
        }
    }


