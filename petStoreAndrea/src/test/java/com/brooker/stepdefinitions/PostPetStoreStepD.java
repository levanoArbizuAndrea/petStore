package com.brooker.stepdefinitions;

import com.brooker.taks.AddPetTask;
import com.brooker.util.BaseUrl;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostPetStoreStepD {

    @Steps
    BaseUrl base;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("^creo una nueva mascota con (.*) su nombre (.*) y su estado (.*)$")
    public void creoUnaNuevaMascotaConIDSuNombreNOMBREYSuEstadoESTADO(String id, String nombre, String estado) {
        theActorInTheSpotlight().attemptsTo(
                AddPetTask.withData(id, nombre, estado)
        );
    }



}
