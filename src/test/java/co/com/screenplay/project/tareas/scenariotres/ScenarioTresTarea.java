package co.com.screenplay.project.tareas.scenariodos;

import co.com.screenplay.project.ui.scenariouno.ScenarioUnoUi;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class ScenarioDosDiaTarea implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ScenarioUnoUi.BTN_MES_SIGUIENTE),
                Click.on(ScenarioUnoUi.BTN_DIA_MES_SIGUIENTE)
        );
    }
    public static ScenarioDosDiaTarea go() {
        return Instrumented.instanceOf(ScenarioDosDiaTarea.class).withProperties();
    }
}
