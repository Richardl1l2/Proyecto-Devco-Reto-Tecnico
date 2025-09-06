package co.com.screenplay.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = {"co.com.screenplay.project.stepdefinitions", "co.com.screenplay.project.hooks"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerOpenWeb {
}