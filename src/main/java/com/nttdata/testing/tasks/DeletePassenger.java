package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeletePassenger implements Task {
    private final String endpoint;

    public DeletePassenger(String endpoint) {
        this.endpoint = endpoint;
    }
    public static Performable fromEndpoint(String endpoint) {
        return instrumented(DeletePassenger.class, endpoint);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(endpoint)
                .with(requestSpecification -> requestSpecification
                        .contentType(ContentType.JSON)
                        .log().all()
                ));
    }


}
