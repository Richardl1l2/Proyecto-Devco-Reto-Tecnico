package co.com.screenplay.project.stepdefinitions.Agendamiento;

import co.com.screenplay.project.preguntas.compra.CompraPregunta;
import co.com.screenplay.project.tareas.agendamiento.caja.CajaTarea;
import co.com.screenplay.project.tareas.agendamiento.destino.DestinoTarea;
import co.com.screenplay.project.tareas.agendamiento.rangoprecio.RangoPrecioTarea;
import co.com.screenplay.project.tareas.agendamiento.partidaregreso.PartidaRegresoTarea;
import co.com.screenplay.project.tareas.agendamiento.resumenpago.ResumenPagoTarea;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class AgendamientoStepDefinition {
    @Dado("que el actor Usuario ha ingresado los datos de partida y regreso:")
    public void queElActorUsuarioHaIngresadoLosDatosDePartidaYRegreso(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                PartidaRegresoTarea.go(dataTable)
        );
    }

    @Y("el usuario filtra los destinos por el rango de precio:")
    public void filtrarDestinosPorRangoDePrecio(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                RangoPrecioTarea.go(dataTable)
        );
    }

    @Y("elige el destino:")
    public void eligeElDestinoTorreEiffel(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                DestinoTarea.go(dataTable)
        );
    }

    @Y("completa el formulario de reserva:")
    public void completaElFormularioDeReserva(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                CajaTarea.go(dataTable)
        );
    }

    @Y("termina de completar los datos faltantes:")
    public void terminaDeCompletarLosDatosFaltantes(DataTable dataTable) {
        theActorInTheSpotlight().attemptsTo(
                ResumenPagoTarea.go(dataTable)
        );
    }

    @Entonces("el sistema debe mostrar el mensaje de confirmacion {string}")
    public void elSistemaDebeMostrarElMensajeDeConfirmacion(String textoEsperado) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        CompraPregunta.value(),
                        equalTo(textoEsperado))
        );
    }
}
