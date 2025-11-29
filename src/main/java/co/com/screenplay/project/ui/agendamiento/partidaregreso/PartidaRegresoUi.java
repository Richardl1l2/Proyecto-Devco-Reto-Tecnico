package co.com.screenplay.project.ui.agendamiento.partidaregreso;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PartidaRegresoUi {

    public static Target BTN_PARTIDA = Target.the("Click sobre el boton de partida")
            .located(By.xpath("//div[@class='Box__box___2XzJ2 Hero__form-box___126DY Hero__margin-compensation___2pwg4']//div[1]//div[1]//div[1]//input[1]"));

    public static Target BTN_REGRESO = Target.the("Click sobre el boton de regreso")
            .located(By.xpath("//body[1]/div[1]/div[1]/section[1]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]"));

    public static Target DIA_DEL_MES(String dia) {
        // Se usa una expresión XPath que busca el elemento <div> o <span> que contenga
        // el texto exacto del día.
        String xpathDinamico = "//span[normalize-space(text())='" + dia + "']/ancestor::div[@data-react-toolbox='day']";

        return Target.the("El día '" + dia + "' en el calendario")
                .located(By.xpath(xpathDinamico));
    }
    public static Target MES_ACTUAL_VISIBLE(String mesYAnio) {
        // Se busca el elemento <span> que contenga el texto del mes y el año (ej. "November 2025")
        // Usamos 'contains()' ya que el texto puede estar dividido por 'react-text'.
        String xpathDinamico = "//div[@data-react-toolbox='month']//span[contains(normalize-space(.), '" + mesYAnio + "')]";

        return Target.the("El título del mes visible: '" + mesYAnio + "'")
                .located(By.xpath(xpathDinamico));
    }
    // Target para el botón de Navegación (Flecha Izquierda)
    public static final Target BTN_ANTERIOR_MES = Target.the("botón para ir al mes anterior")
            .locatedBy("//button[contains(@class, 'theme__prev___')]");

    // Target para el botón de Navegación (Flecha Derecha/Siguiente)
    public static final Target BTN_SIGUIENTE_MES = Target.the("botón para ir al mes siguiente")
            .locatedBy("//button[contains(@class, 'theme__next___')]");

    public static Target BTN_OK = Target.the("Click sobre el boton OK de partida")
            .located(By.xpath("//button[normalize-space()='Ok']"));

    public static Target BTN_ADULTOS = Target.the("Click sobre el boton de adultos")
            .located(By.xpath("//input[@value='Adults (18+)']"));

    public static Target OPCION_DROPDOWN_ADULTOS(String valor) {

        // 🚀 SOLUCIÓN: Usar la función contains(@class, 'subcadena')
        // Esto es más robusto y evita el error de sintaxis del operador *= en algunos drivers.
        String xpathDinamico = "(//ul[contains(@class, 'theme__values___')]//li[normalize-space(text())='" + valor + "'])[1]";

        return Target.the("Opción '" + valor + "' en el menú desplegable")
                .located(By.xpath(xpathDinamico));
    }

    public static Target BTN_NINOS = Target.the("Click sobre el boton de ninos")
            .located(By.xpath("//input[@value='Children (0-7)']"));

    public static Target OPCION_DROPDOWN_NINOS(String valor) {
        String xpathDinamico = "(//ul[contains(@class, 'theme__values___')]//li[normalize-space(text())='" + valor + "'])[2]";

        return Target.the("Opción Children '" + valor + "' en el menú desplegable (Índice 2)")
                .located(By.xpath(xpathDinamico));
    }

}

