package pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.ClickOnBy;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class Home extends PageObject {
    @FindBy(id = "menu-toggle")
    private WebElementFacade toggle;

    @FindBy(id ="btn-make-appointment")
    private WebElementFacade makeAppointmentBtn;

    @FindBy(xpath = "//li/a[text()='Login']")
    private WebElementFacade loginOption;

    @FindBy(id = "txt-username")
    private  WebElementFacade usernameTxt;

    @FindBy(id = "txt-password")
    private WebElementFacade passwordTxt;

    @FindBy(id = "btn-login")
    private WebElementFacade loginBtn;

    public void selectLoginOption(){
        toggle.withTimeoutOf(Duration.ofSeconds(30)).isVisible();
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", toggle);
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", loginOption);
    }

    public void login(String username, String password){
        usernameTxt.type(username);
        passwordTxt.type(password);
        loginBtn.click();
    }


}
