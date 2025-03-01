package com.brooker.stepdefinitions;

import com.brooker.taks.GetPetTask;
import com.brooker.util.BaseUrl;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.brooker.questions.StatusQuestion.httpStatusCode;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class GetPetStoreStepD {
    @Steps
    BaseUrl base;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("que soy un usuario autorizado para interactuar con las APIs de swagger")
    public void queSoyUnUsuarioAutorizadoParaInteractuarConLasAPIsDeSwagger() {
        theActorCalled("user").whoCan(CallAnApi.at(base.getUrl()));
    }
    @When("^realizo una consulta de la mascota con (.*)$")
    public void realizoUnaConsultaDeLaMascotaConID(int idMascota) {
        theActorInTheSpotlight().attemptsTo(
                GetPetTask.withData(idMascota)
        );
    }

    @Then("^se valida la ejecucion (.*)$")
    public void seValidaLaEjecucionCODIGO(int statuscodigo) {
        theActorInTheSpotlight().should(seeThat("El estado del código http", httpStatusCode(), equalTo(statuscodigo)));
    }
}
