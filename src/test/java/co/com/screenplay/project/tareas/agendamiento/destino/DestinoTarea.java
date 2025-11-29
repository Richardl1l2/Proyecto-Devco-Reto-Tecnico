package co.com.screenplay.project.tareas.agendamiento.destino;

import co.com.screenplay.project.agendamiento.destino.DestinoUi;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Map;

public class DestinoTarea implements Task {

    private final DataTable data;

    public DestinoTarea(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);
        String destinoElegido = values.get(0).get("destino_elegido");

        actor.attemptsTo(
                Click.on(DestinoUi.BTN_UBICACION_VIAJE),
                Click.on(DestinoUi.ELEMENTO_LISTA_DINAMICO(destinoElegido)),
                Click.on(DestinoUi.BTN_BOOK)
        );
    }

    public static DestinoTarea go(DataTable data) {
        return Tasks.instrumented(DestinoTarea.class, data);
    }
}
