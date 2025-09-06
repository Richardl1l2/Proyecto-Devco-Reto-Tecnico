package co.com.screenplay.project.tareas;

import co.com.screenplay.project.ui.scenariouno.ScenarioUnoUi;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Switch;

public class ScenarioUnoIframeTarea implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame(ScenarioUnoUi.IFRAME_CALENDARIO.resolveFor(actor))
        );
    }
    public static ScenarioUnoIframeTarea go() {
        return Instrumented.instanceOf(ScenarioUnoIframeTarea.class).withProperties();
    }
}
