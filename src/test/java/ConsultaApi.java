import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.notNullValue;

//@RunWith(SerenityRunner.class)
public class ConsultaApi {
/*
    private static final String restApiUrl = "https://dummy.restapiexample.com/api";

    @Test
    public void getUsers(){
        Actor actor = Actor.named("Consulta de api").whoCan(CallAnApi.at(restApiUrl));

        //actor.attemptsTo(Get.resource("/v1/employees"));
        // assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);

        actor.attemptsTo(
               GetEmployees.fromPage(1)
        );

        actor.should(seeThat("el codigo de respuesta", ResponseCode.was(), equalTo(200))
        );

        Datum employees = new GetEmployeesQuestion().answeredBy(actor)
                .getData().stream().filter(x->x.getId()==1).findFirst().orElse(null);

        actor.should(
                seeThat("Empleados es nulo",actor1 -> employees,notNullValue())
        );
        actor.should(seeThat("El nombre del empleado", actor1-> employees.getEmployeeName()
        , equalTo("Tiger Nixon")));
    }*/
}
