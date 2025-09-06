package co.com.screenplay.project.tareas.scenariotres;

import co.com.screenplay.project.ui.CalendarioUi;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class ScenarioTresTarea implements Task {

    private final String fechaManual;

    public ScenarioTresTarea(String fechaManual) {
        this.fechaManual = fechaManual;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CalendarioUi.FIELD_DATAPICKER),
                Enter.keyValues(fechaManual).into(CalendarioUi.FIELD_DATAPICKER)                );
    }
    public static ScenarioTresTarea go(String fechaManual) {
        return Instrumented.instanceOf(ScenarioTresTarea.class).withProperties(fechaManual);
    }
}
