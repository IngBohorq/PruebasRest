package stepdefinitions;

import apiget.questions.ResponseCode;
import apiget.tasks.DeleteEmployees;
import apiget.tasks.GetEmployees;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class EliminarRegistroStepdefinitions {
    Actor actor;
    @When("se envia el registro a eliminar servicio")
    public void seEnviaElRegistroAEliminarServicio(DataTable dataTable) {
        actor.attemptsTo(
                DeleteEmployees.frompPage(dataTable)
        );
    }

    @Then("se registra eliminacion existosa")
    public void seRegistraEliminacionExistosa() {
        actor.should(seeThat("el codigo de respuesta", ResponseCode.was(), equalTo(201)));
    }
}
