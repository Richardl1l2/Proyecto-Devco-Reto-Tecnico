package co.com.screenplay.project.hooks;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


public class Hook {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());  // <- esto inicializa el Stage
    }

    @Before("@scenarioUno")
    public void loginWithCredentialsloginAdminCarnicos() {
        OnStage.theActorCalled("User").attemptsTo(
                Web.browserURL()
        );
    }
}

