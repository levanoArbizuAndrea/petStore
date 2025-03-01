package com.brooker.taks;

import com.brooker.util.Endpoint;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetPetTask implements Task {

    private final int idMascota;

    public GetPetTask(int idMascota) {
        this.idMascota = idMascota;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Endpoint.GET_PET.getEndpoint() + idMascota)
                        .with(requestSpecification -> requestSpecification
                                .log().all()
                                .relaxedHTTPSValidation()
                        )
        );

        String responseBody = SerenityRest.lastResponse().getBody().asString();
        System.out.println("Respuesta del servicio: " + responseBody);
    }


    public static Performable withData(int id) {
        return instrumented(GetPetTask.class, id);
    }
}
