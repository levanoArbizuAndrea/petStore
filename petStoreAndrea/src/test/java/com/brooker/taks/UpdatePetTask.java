package com.brooker.taks;

import com.brooker.util.Commons;
import com.brooker.util.Endpoint;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdatePetTask implements Task {

    private final String id;
    private final String nombre;
    private final String estado;

    public UpdatePetTask(String id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(Endpoint.PUT_PET.getEndpoint()+id)
                        .with(requestSpecification -> requestSpecification
                                .log().all()
                                .relaxedHTTPSValidation()
                                .contentType(ContentType.JSON)
                                .body(Commons.getJson("/request/newPet.json")
                                        .replace("{id}", id)
                                        .replace("{name}", nombre)
                                        .replace("{status}", estado)
                                )
                        )
        );
    }

    public static Performable withData(String id, String nombre, String estado) {
        return instrumented(UpdatePetTask.class, id, nombre, estado);
    }
}
