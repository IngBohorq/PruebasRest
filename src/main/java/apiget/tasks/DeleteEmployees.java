package apiget.tasks;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;


import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteEmployees implements Task {
    private DataTable data;

    public DeleteEmployees(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);
        String registro = values.get(0).get("page");

        actor.attemptsTo(
                Delete.from("/v1/delete/"+registro)
        );
    }
    public static Performable frompPage(DataTable data)
    {
        return instrumented(DeleteEmployees.class, data);
    }
}

