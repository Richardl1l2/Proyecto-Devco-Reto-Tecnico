package co.com.screenplay.project.tareas.scenariouno;

import co.com.screenplay.project.ui.CalendarioUi;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ScenarioUnoDiaTarea implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CalendarioUi.BTN_DIA)
        );
    }
    public static ScenarioUnoDiaTarea go() {
        return Instrumented.instanceOf(ScenarioUnoDiaTarea.class).withProperties();
    }
}
