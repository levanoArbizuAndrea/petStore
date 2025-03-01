package com.brooker.taks;

import com.brooker.util.Commons;
import com.brooker.util.Endpoint;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddPetTask implements Task {

    private final String id;
    private final String nombre;
    private final String estado;

    public AddPetTask(String id, String nombre, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(Endpoint.POST_PET.getEndpoint())
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
        return instrumented(AddPetTask.class, id, nombre, estado);
    }
}
