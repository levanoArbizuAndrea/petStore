package com.brooker.stepdefinitions;

import com.brooker.taks.AddPetTask;
import com.brooker.util.BaseUrl;
import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PutPetStoreStepD {

    @Steps
    BaseUrl base;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("realizo una actualizacion de la mascota con {int} modificando su nombre {string} y su estado {string}")
    public void realizo_una_actualizacion_de_la_mascota_con_modificando_su_nombre_y_su_estado(Integer id, String nombre, String estado) {
        theActorInTheSpotlight().attemptsTo(
                AddPetTask.withData(String.valueOf(id), nombre, estado)
        );
    }


}
