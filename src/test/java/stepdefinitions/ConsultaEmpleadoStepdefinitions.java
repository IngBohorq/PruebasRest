package stepdefinitions;

import apiget.questions.GetEmployeesQuestion;
import apiget.questions.ResponseCode;
import apiget.models.Datum;
import apiget.tasks.GetEmployees;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ConsultaEmpleadoStepdefinitions {

    Actor actor;
    private static final String restApiUrl = "https://dummy.restapiexample.com/api";
    @Given("Usuario invoca la consulta de la api")
    public void usuarioInvocaLaConsultaDeLaApi() {
        actor = Actor.named("Consulta de api").whoCan(CallAnApi.at(restApiUrl));
    }

    @When("el consulta los registro")
    public void elConsultaLosRegistro(DataTable dataTable) {
        actor.attemptsTo(GetEmployees.fromPage(dataTable));
    }

    @Then("el verifica el registro en el servicio")
    public void elVerificaElRegistroEnElServicio() {
        Datum employees = new GetEmployeesQuestion().answeredBy(actor)
                .getData().stream().filter(x->x.getId()==1).findFirst().orElse(null);
        actor.should(seeThat("el codigo de respuesta", ResponseCode.was(), equalTo(200))
        );
        actor.should(
                seeThat("Empleados es nulo",actor1 -> employees,notNullValue())
        );
        actor.should(seeThat("El nombre del empleado", actor1-> employees.getEmployeeName()
                , equalTo("Tiger Nixon")));
    }
}
