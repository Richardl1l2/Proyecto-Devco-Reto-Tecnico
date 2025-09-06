package co.com.screenplay.project.stepdefinitions.scenariotres;

import co.com.screenplay.project.preguntas.scenariotres.CampoDatepickerAceptaManualPregunta;
import co.com.screenplay.project.preguntas.scenariotres.FechaCalendarioPregunta;
import co.com.screenplay.project.tareas.scenariodos.ScenarioDosDiaTarea;
import co.com.screenplay.project.tareas.scenariotres.ScenarioTresTarea;
import co.com.screenplay.project.tareas.scenariotres.SeleccionarFechaCalendarioTarea;
import co.com.screenplay.project.tareas.scenariouno.ImprimirFecha;
import co.com.screenplay.project.utilidades.DiaAleatorio;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.core.IsEqual.equalTo;


public class SeleccionarFechaCalendarioStepDefinition {
    @Cuando("Seleccionar cualquier fecha del calendario.")
    public void seleccionarCualquierFechaDelCalendario() {
        theActorInTheSpotlight().attemptsTo(
                SeleccionarFechaCalendarioTarea.go(),
                ImprimirFecha.ahora()
        );
    }

    @Entonces("Validar que solo es posible seleccionar una fecha desde el calendario.")
    public void validarQueSoloEsPosibleSeleccionarUnaFechaDesdeElCalendario() {
        String diaAleatorio = DiaAleatorio.getUltimoDiaGenerado();

        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        FechaCalendarioPregunta.value(),
                        equalTo(diaAleatorio)
                )
        );
    }

}
