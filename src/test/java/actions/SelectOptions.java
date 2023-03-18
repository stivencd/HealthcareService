package actions;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.core.Serenity.getDriver;

import java.util.List;

public class SelectOptions {
    public static void in(List<WebElementFacade> elements, String value) {
        for (WebElement element : elements) {
            if (element.getText().contains(value)) {
                JavascriptExecutor js = (JavascriptExecutor) getDriver();
                js.executeScript("arguments[0].click();", element);
                break;
            }
        }
    }
}
