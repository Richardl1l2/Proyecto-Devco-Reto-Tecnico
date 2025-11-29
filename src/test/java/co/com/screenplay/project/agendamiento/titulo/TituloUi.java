package co.com.screenplay.project.agendamiento.titulo;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TituloUi {

    public static Target TXT_VALIDAR_TITULO = Target.the("Validacion del titulo en la pagina")
            .located(By.xpath("//h1[normalize-space()='Space & Beyond']"));
}

