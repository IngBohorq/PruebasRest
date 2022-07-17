package apiget.questions;

import apiget.models.Employees;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetEmployeesQuestion  implements Question {
    @Override
    public Employees answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as(Employees.class);
    }
}
