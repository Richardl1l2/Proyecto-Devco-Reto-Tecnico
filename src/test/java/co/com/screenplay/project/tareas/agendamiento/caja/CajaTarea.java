package co.com.screenplay.project.tareas.agendamiento.caja;

import co.com.screenplay.project.agendamiento.caja.CajaUi;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;

import java.util.List;
import java.util.Map;


public class CajaTarea implements Task {

    private final DataTable data;

    public CajaTarea(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Map<String, String>> values = data.asMaps(String.class, String.class);

        String nombre = values.get(0).get("name");
        String correo = values.get(0).get("email");
        String ssn = values.get(0).get("SSN");
        String telefono = values.get(0).get("phone");

        String filePath = "C:\\Users\\PCC\\Documents\\Pruebas qa.pdf";

        actor.attemptsTo(
                Enter.theValue(nombre).into(CajaUi.FIELD_NOMBRE),
                Enter.theValue(correo).into(CajaUi.FIELD_CORREO),
                Enter.theValue(ssn).into(CajaUi.FIELD_SEGURIDAD_SOCIAL),
                Enter.theValue(telefono).into(CajaUi.FIELD_NUMERO_TEL),
                Scroll.to(CajaUi.INPUT_FILE),
                Enter.keyValues(filePath).into(CajaUi.INPUT_FILE)
        );
    }

    public static CajaTarea go(DataTable data) {
        return Tasks.instrumented(CajaTarea.class, data);
    }
}
