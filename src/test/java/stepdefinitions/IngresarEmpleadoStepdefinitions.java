package stepdefinitions;

import apiget.models.RegistrerUserInfo;
import apiget.questions.ResponseCode;
import apiget.tasks.RegisterUser;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class IngresarEmpleadoStepdefinitions {
    Actor actor;
    @When("el envia la informacion requerida por el servicio")
    public void elEnviaLaInformacionRequeridaPorElServicio() {
        RegistrerUserInfo registerUserInfo = new RegistrerUserInfo();
        registerUserInfo.setName("Juan");
        registerUserInfo.setSalary("580000");
        registerUserInfo.setEdad("30");
        actor.attemptsTo(
                RegisterUser.withInfo(registerUserInfo)
        );
    }
    @Then("se registra ingreso exitoso en el sistema")
    public void seRegistraIngresoExitosoEnElSistema() {
        actor.should(seeThat("el codigo de respuesta", ResponseCode.was(), equalTo(201)));
    }

}
