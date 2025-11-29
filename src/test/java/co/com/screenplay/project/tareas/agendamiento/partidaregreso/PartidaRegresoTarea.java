package co.com.screenplay.project.tareas.agendamiento.partidaregreso;

import co.com.screenplay.project.ui.agendamiento.partidaregreso.PartidaRegresoUi;
import co.com.screenplay.project.utilidades.NavegarMesesPartida;
import co.com.screenplay.project.utilidades.NavegarMesesRegreso;
import co.com.screenplay.project.utilidades.Espera;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PartidaRegresoTarea implements Task {

    private final DataTable data;

    public PartidaRegresoTarea(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);
        String mesPartida = values.get(0).get("partida_mes");
        String diaPartida = values.get(0).get("partida_dia");
        String mesRegreso = values.get(0).get("regreso_mes");
        String diaRegreso = values.get(0).get("regreso_dia");
        String adultos = values.get(0).get("adultos");
        String ninos = values.get(0).get("ninos");

        actor.attemptsTo(
                Click.on(PartidaRegresoUi.BTN_PARTIDA),
                NavegarMesesPartida.untilVisible(mesPartida),
                Espera.waitForMilliseconds(1000),
                Click.on(PartidaRegresoUi.DIA_DEL_MES(diaPartida)),
                Click.on(PartidaRegresoUi.BTN_OK),
                WaitUntil.the(PartidaRegresoUi.MES_ACTUAL_VISIBLE(""), isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(PartidaRegresoUi.BTN_REGRESO),
                NavegarMesesRegreso.untilVisible(mesRegreso),
                Espera.waitForMilliseconds(1000),
                Click.on(PartidaRegresoUi.DIA_DEL_MES(diaRegreso)),
                Click.on(PartidaRegresoUi.BTN_OK),
                Click.on(PartidaRegresoUi.BTN_ADULTOS),
                WaitUntil.the(PartidaRegresoUi.OPCION_DROPDOWN_ADULTOS(adultos), isVisible()).forNoMoreThan(5).seconds(),
                Click.on(PartidaRegresoUi.OPCION_DROPDOWN_ADULTOS(adultos)),
                Click.on(PartidaRegresoUi.BTN_NINOS),
                WaitUntil.the(PartidaRegresoUi.OPCION_DROPDOWN_NINOS(ninos), isVisible()).forNoMoreThan(5).seconds(),
                Click.on(PartidaRegresoUi.OPCION_DROPDOWN_NINOS(ninos))
                );
    }

    public static PartidaRegresoTarea go(DataTable data) {
        return Tasks.instrumented(PartidaRegresoTarea.class, data);
    }
}
