package co.com.screenplay.project.preguntas.titulopregunta;

import co.com.screenplay.project.agendamiento.titulo.TituloUi;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class TituloPregunta implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(TituloUi.TXT_VALIDAR_TITULO, isVisible())
                        .forNoMoreThan(10).seconds()
        );

        return TituloUi.TXT_VALIDAR_TITULO.resolveFor(actor).getText();
    }

    public static TituloPregunta value() {
        return new TituloPregunta();
    }
}
