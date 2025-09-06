package co.com.screenplay.project.tareas;

import co.com.screenplay.project.ui.scenariouno.ScenarioUnoUi;
import co.com.screenplay.project.utilidades.wait;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ScenarioUnoFechaTarea implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ScenarioUnoUi.FIELD_DATAPICKER),
                wait.waitForMilliseconds(10)
        );
    }
    public static ScenarioUnoFechaTarea go() {
        return Instrumented.instanceOf(ScenarioUnoFechaTarea.class).withProperties();
    }
}
