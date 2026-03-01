package tests;

import Utils.ConstantPath;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ConstantPath.FeatureFilePath,
        plugin = {"pretty", ConstantPath.cucumberhtmlreport, ConstantPath.cucumberjsonreport},
        glue = {"StepDefinition"})
public class TestRunner {
//, tags = "@DeletePlace"
}
