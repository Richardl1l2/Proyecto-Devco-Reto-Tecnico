package co.com.screenplay.project.tareas.agendamiento.resumenpago;

import co.com.screenplay.project.agendamiento.resumenpago.ResumenPagoUi;
import co.com.screenplay.project.utilidades.Espera;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ResumenPagoTarea implements Task {

    private final DataTable data;

    public ResumenPagoTarea(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Map<String, String>> values = data.asMaps(String.class, String.class);

        String codigoPromocional = values.get(0).get("codigo_promocional");

        actor.attemptsTo(
                WaitUntil.the(ResumenPagoUi.FIELD_CODIGO_PROMO, isClickable()).forNoMoreThan(10).seconds(),
                Enter.theValue(codigoPromocional).into(ResumenPagoUi.FIELD_CODIGO_PROMO),
                WaitUntil.the(ResumenPagoUi.BTN_APLICAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ResumenPagoUi.BTN_APLICAR),
                Click.on(ResumenPagoUi.CHECKBOX_TERMINOS_CONDICIONES),
                Click.on(ResumenPagoUi.BTN_PAY_NOW),
                Espera.waitForMilliseconds(5000)
        );
    }

    public static ResumenPagoTarea go(DataTable data) {
        return Tasks.instrumented(ResumenPagoTarea.class, data);
    }
}
