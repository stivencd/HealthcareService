package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageobject.Appointment;
import pageobject.Home;

public class AppointmentStepsDefinitions {
    @Steps
    Home home;

    @Steps
    Appointment appointment;


    @Given("^como usuario deseo programar un cita medica en la web$")
    public void comoUsuarioDeseoProgramarUnCitaMedicaEnLaWeb() {
        home.open();
    }

    @When("^presiono el boton login del menu hamburguesa$")
    public void presionoElBotonLoginDelMenuHamburguesa() {
        home.selectLoginOption();
    }

    @Then("^se autentifica para programar un cita medica con las credenciales de prueba (.*) y (.*)$")
    public void seAutentificaParaProgramarUnCitaMedicaConLasCredencialesDePruebaUsernameYPassword(String username, String password) {
        home.login(username, password);
    }

    @And("^valido que me muestre el formulario y programo mi cita medica$")
    public void validoQueMeMuestreElFormularioYProgramoMiCitaMedica() {
        appointment.validateAppointmentForm();
    }

    @And("^ingreso la ubicacion del centro medico (.*), selecciono la opcion aplico para readmision (.*), selecciono el programa de salud (.*),  programo la fecha de visita (.*) y agrego un comentario (.*)$")
    public void ingresoLaUbicacionDelCentroMedicoFacilitySeleccionoLaOpcionAplicoParaReadmisionApplySeleccionoElProgramaDeSaludHealthcare_programProgramoLaFechaDeVisitaVisit_dateYAgregoUnComentarioComment(
            String facility, boolean applyReadmission, String healthcareProgram, String visitDate, String comment
    ) {
        appointment.save(facility, applyReadmission, healthcareProgram, visitDate, comment);
    }

    @Then("^vizualizo el mensaje de cita confirmada (.*)$")
    public void vizualizoElMensajeDeCitaConfirmadaMessage(String message) {
        appointment.validateMessageConfirmation(message);
    }

    @And("^confirmo los datos ingresados (.*), (.*), (.*), (.*), (.*)")
    public void confirmoLosDatosIngresadosFacilityApplyHealthcare_programVisit_dateComment(
            String facility, boolean applyReadmission, String healthcareProgram, String visitDate, String comment
    ) {
        appointment.validateAppointment(facility, applyReadmission, healthcareProgram, visitDate, comment);
    }


    @Then("^vizualizo el mensaje de campo requerido (.*)$")
    public void vizualizoElMensajeDeCampoRequeridoMessage(String message) {
        appointment.validateVisitDateFieldIsRequired(message);
    }
}
