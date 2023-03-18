package pageobject;

import actions.SelectOptions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Appointment extends PageObject {
    @FindBy(xpath = "//h2")
    private  WebElementFacade title;

    @FindBy(id ="combo_facility")
    private WebElementFacade facilitySelect;

    @FindBy(id = "chk_hospotal_readmission")
    private WebElementFacade readmissionCheckBox;

    @FindBy(id="txt_visit_date")
    private WebElementFacade visitDateTxt;

    @FindBy(xpath = "//label[@class='radio-inline']")
    private List<WebElementFacade> healthcareProgramBtn;

    @FindBy(id="txt_comment")
    private WebElementFacade commentTxt;

    @FindBy(id ="btn-book-appointment")
    private WebElementFacade appointmentBtn;

    @FindBy(id="facility")
    private WebElementFacade facilityConfirmed;

    @FindBy(id="hospital_readmission")
    private WebElementFacade readmissionConfirmed;

    @FindBy(id="program")
    private WebElementFacade programConfirmed;

    @FindBy(id="visit_date")
    private WebElementFacade visitDateConfirmed;

    @FindBy(id="comment")
    private WebElementFacade commentConfirmed;


    public void validateAppointmentForm(){
        Assert.assertNotNull(title);
        title.withTimeoutOf(Duration.ofSeconds(20)).isVisible();
        Assert.assertEquals("Make Appointment", title.getText());
    }

    public void save(String facility, boolean applyReadmission, String healthcareProgram, String visitDate, String comment){
        Assert.assertNotNull(facilitySelect);
        Select elementFacility = new Select( facilitySelect);
        elementFacility.selectByVisibleText(facility);
        if(applyReadmission){
            readmissionCheckBox.click();
        }
        visitDateTxt.type(visitDate);
        SelectOptions.in(healthcareProgramBtn, healthcareProgram);
        commentTxt.type(comment);
        appointmentBtn.click();
    }

    public void validateMessageConfirmation(String message){
        title.withTimeoutOf(Duration.ofSeconds(20)).isVisible();
        Assert.assertNotNull(title);
        Assert.assertEquals(message, title.getText());
    }

    public void validateAppointment(String facility, boolean applyReadmision, String healthcareProgram, String visitDate, String comment) {
        Assert.assertEquals("El campo facility no coincide", facility, facilityConfirmed.getText());
        Assert.assertEquals("El campo readmission no coincide", applyReadmision, readmissionConfirmed.getText().equals("Si"));
        Assert.assertEquals("El campo program no coincide", healthcareProgram, programConfirmed.getText());
        Assert.assertEquals("El campo visit date no coincide", visitDate, visitDateConfirmed.getText());
        Assert.assertEquals("El campo comment no coincide", comment, commentConfirmed.getText());
    }

    public void validateVisitDateFieldIsRequired(String alert){
        String message = visitDateTxt.getAttribute("validationMessage");
        Assert.assertNotNull(visitDateTxt);
        Assert.assertTrue(visitDateTxt.getText().isEmpty());
        Assert.assertEquals("Mensaje de validacion no coincide", alert,  message);

    }
}
