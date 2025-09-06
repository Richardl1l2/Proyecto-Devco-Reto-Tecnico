package co.com.screenplay.project.tareas;

import co.com.screenplay.project.ui.ScenarioUnoUi;
import co.com.screenplay.project.utilidades.wait;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ScenarioUnoDiaTarea implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ScenarioUnoUi.BTN_DIA)
        );
    }
    public static ScenarioUnoDiaTarea go() {
        return Instrumented.instanceOf(ScenarioUnoDiaTarea.class).withProperties();
    }
}
