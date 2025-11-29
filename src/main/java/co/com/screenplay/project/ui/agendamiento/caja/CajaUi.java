package co.com.screenplay.project.ui.agendamiento.caja;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CajaUi {

    public static Target FIELD_NOMBRE = Target.the("Click sobre el campo nombre")
            .located(By.xpath("//form//div[1]//input[1]"));

    public static Target FIELD_CORREO = Target.the("Click sobre el campo correo")
            .located(By.xpath("//input[@type='email']"));

    public static Target FIELD_SEGURIDAD_SOCIAL = Target.the("Click sobre el campo seguridad social")
            .located(By.xpath("(//input[@role='input'])[11]"));

    public static Target FIELD_NUMERO_TEL = Target.the("Click sobre el campo numero telefonico")
            .located(By.xpath("//input[@type='tel']"));

    public static final Target INPUT_FILE =
            Target.the("input para subir archivo")
                    .located(By.xpath("//input[@type='file']"));

}

