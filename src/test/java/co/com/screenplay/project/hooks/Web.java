package co.com.screenplay.project.hooks;

import co.com.screenplay.project.utilidades.Constantes;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.util.EnvironmentVariables;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Web implements Task {

    private EnvironmentVariables environmentVariables;

    @Override
    public <T extends Actor> void performAs(T actor) {
        String pathwebUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(Constantes.WEB_URL);
        actor.attemptsTo(Open.url(pathwebUrl));
    }
    public static Performable browserURL(){
        return instrumented(Web.class);
    }
}
