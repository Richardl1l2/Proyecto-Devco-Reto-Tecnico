package co.com.screenplay.project.tareas.agendamiento.rangoprecio;

import co.com.screenplay.project.agendamiento.rangoprecio.RangoPrecioUi;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class RangoPrecioTarea implements Task {

    private final DataTable data;

    public RangoPrecioTarea(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);
        String precio = values.get(0).get("precio");

        actor.attemptsTo(
                Click.on(RangoPrecioUi.BTN_DESTINO),
                Click.on(RangoPrecioUi.BTN_CARGAR_MAS),
                Click.on(RangoPrecioUi.FIELD_PRECIO),
                SendKeys.of(Keys.CONTROL, "a").into(RangoPrecioUi.FIELD_PRECIO),
                SendKeys.of(Keys.DELETE).into(RangoPrecioUi.CAMPO_VALOR_PRECIO),
                Enter.theValue(precio).into(RangoPrecioUi.CAMPO_VALOR_PRECIO),
                SendKeys.of(Keys.ENTER).into(RangoPrecioUi.CAMPO_VALOR_PRECIO)
        );
    }

    public static RangoPrecioTarea go(DataTable data) {
        return Tasks.instrumented(RangoPrecioTarea.class, data);
    }
}
