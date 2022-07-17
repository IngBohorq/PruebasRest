package apiget.tasks;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetEmployees implements Task {
    private DataTable data;

    public GetEmployees(DataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<Map<String, String>> values = data.asMaps(String.class, String.class);
        String page = values.get(0).get("page");
        if (!(page.equals("0")))
        {
            actor.attemptsTo(
                    Get.resource("/v1/employee/"+page)
                            .with(requestSpecification
                                    -> requestSpecification.contentType(ContentType.JSON)
                                    .header("header1", "value"))
            );
        }
        else {
            actor.attemptsTo(
                    Get.resource("/v1/employees")
                            .with(requestSpecification
                                    -> requestSpecification.contentType(ContentType.JSON)
                                    .header("header1", "value"))
            );

        }

    }

    public static Performable fromPage(DataTable data)
    {
        return instrumented(GetEmployees.class, data);
    }
}
