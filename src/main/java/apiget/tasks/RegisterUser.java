package apiget.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUser implements Task {

    public RegisterUser(Object userinfo) {
        this.userinfo = userinfo;
    }
    private  final Object userinfo;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/api/users").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userinfo)
                )
        );
    }

    public static Performable withInfo(Object userInfo)
    {
        return instrumented(RegisterUser.class, userInfo);
    }
}