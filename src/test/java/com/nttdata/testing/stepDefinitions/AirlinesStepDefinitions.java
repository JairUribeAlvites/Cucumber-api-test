package com.nttdata.testing.stepDefinitions;

import com.nttdata.testing.questions.ResponseCode;
import com.nttdata.testing.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class AirlinesStepDefinitions {
    public static Logger LOGGER = LoggerFactory.getLogger(AirlinesStepDefinitions.class);

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    //CP01
    @Given("el {actor} establece el endpoint GET para obtener las aerolineas")
    public void elActorEstableceElEndpointParaObtenerLasAerolineas(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el {actor} envia una solicitud HTTP GET")
    public void elActorEnviaUnaSolicitudGET(Actor actor) {
        actor.attemptsTo(GetAirlines.fromEndpoint("/airlines"));
    }

    @Then("el codigo de respuesta HTTP deberia ser {int}")
    public void elCodigoDeRespuestaDeberiaSer(int responseCode) {
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseCode.getStatus(), equalTo(responseCode)));
    }
    //CP02
    @Given("el {actor} establece el endpoint POST para crear una aerolinea")
    public void elActorEstableceElEndpointPOSTParaCrearUnaAerolinea(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }


    @When("el envia una solicitud HTTP POST con el {string} {string} {string} {string} {string} {string} {string} {string}")
    public void elEnviaUnaSolicitudHTTPPOSTConEl(String _id, String name, String country, String logo, String slogan, String head_quaters, String website, String established) {
        theActorInTheSpotlight().attemptsTo(PostAirline.fromPage(_id, name, country, logo, slogan, head_quaters, website, established));
    }

    //CP_03
    // Step for setting up the endpoint with ID
    @Given("el {actor} establece el endpoint GET para obtener la aerolinea con id")
    public void elActorEstableceElEndpointParaObtenerLaAerolineaConId(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));

    }

    // Step for sending the GET request with ID
    @When("el {actor} envia una solicitud HTTP GET para obtener la aerolinea por id {string}")
    public void elActorEnviaUnaSolicitudGETParaObtenerLaAerolineaPorId(Actor actor, String id) {

        actor.attemptsTo(GetAirlines.fromEndpoint("/airlines/" + id));
    }
    //CP04
    @Given("el {actor} establece el endpoint GET para obtener pasajero con id {string}")
    public void elActorEstableceElEndpointParaObtenerPasajeroConId(Actor actor, String id) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
        actor.remember("pasajeroId", id);
    }

    // Step for sending the GET request with ID
    @When("el {actor} envia una solicitud HTTP GET para obtener pasajero por id")
    public void elActorEnviaUnaSolicitudGETParaObtenerPasajeroPorId(Actor actor) {
        String id = actor.recall("pasajeroId");
        actor.attemptsTo(GetPassenger.fromEndpoint("/passenger/" + id));
    }


    //CP05
    @Given("el {actor} establece el endpoint POST para crear un pasajero")
    public void elActorEstableceElEndpointPOSTParaCrearUnPasajero(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el envia una solicitud HTTP POST con el {string} {string} {string}")
    public void elEnviaUnaSolicitudHTTPPOSTConEl(String name, String trips, String airline) {
        theActorInTheSpotlight().attemptsTo(PostPassenger.fromPage(name, trips, airline));
    }

    //CP06
    @Given("el {actor} establece el endpoint GET para obtener pasajero")
    public void elActorEstableceElEndpointGETParaObtenerPasajero(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el {actor} envia una solicitud HTTP DELETE para obtener borrar con id {string}")
    public void elActorEnviaUnaSolicitudHTTPDELETEParaObtenerBorrarConId(Actor actor, String id) {
        actor.attemptsTo(DeletePassenger.fromEndpoint("/passenger/" + id));
    }
}
