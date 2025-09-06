package co.com.screenplay.project.ui.scenariouno;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ScenarioUnoUi {

    public static Target IFRAME_CALENDARIO = Target.the("Iframe que contiene el calendario")
            .located(By.cssSelector("iframe.demo-frame"));

    public static Target FIELD_DATAPICKER = Target.the("Campo datepicker")
            .located(By.id("datepicker"));

    public static Target BTN_DIA = Target.the("Seleccionar el dia 15")
            .located(By.xpath("//a[normalize-space()='15']"));

    public static Target BTN_MES_SIGUIENTE = Target.the("Mes siguiente")
            .located(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));


    public static Target BTN_DIA_MES_SIGUIENTE = Target.the("Seleccionar el dia 10")
            .located(By.xpath("//a[normalize-space()='10']"));


    public static Target BTN_DIA_ALEATORIO = Target.the("Seleccionar el dia aleatorio")
            .located(By.xpath("//a[normalize-space()='15']"));
}
