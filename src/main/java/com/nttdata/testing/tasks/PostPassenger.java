package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostPassenger implements Task {
    private final String name, trips, airline;

    public PostPassenger(String name, String trips, String airline) {
        this.name = name;
        this.trips = trips;
        this.airline = airline;
    }
    public static Performable fromPage(String name, String trips, String airline) {
        return instrumented(PostPassenger.class,name, trips, airline);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to("/airlines").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                .body("{\"name\":\"" + name
                        + "\"," + "\"country\":\"" + trips
                        + "\"," + "\"logo\":\"" + airline
                        + "\"}")
                .log().all()));
    }
}
