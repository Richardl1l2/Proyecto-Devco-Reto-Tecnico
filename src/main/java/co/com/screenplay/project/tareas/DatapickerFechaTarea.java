package co.com.screenplay.project.tareas;

import co.com.screenplay.project.ui.CalendarioUi;
import co.com.screenplay.project.utilidades.wait;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class DatapickerFechaTarea implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CalendarioUi.FIELD_DATAPICKER),
                wait.waitForMilliseconds(10)
        );
    }
    public static DatapickerFechaTarea go() {
        return Instrumented.instanceOf(DatapickerFechaTarea.class).withProperties();
    }
}
