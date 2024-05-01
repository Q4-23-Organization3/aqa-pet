package hw23.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("hw23/stepdeffs")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "hw23/stepdeffs")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features/petstore.feature")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber.html")
public class RunnerTest {
}
