package com.brooker.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class StatusQuestion {
    public static Question<Integer> httpStatusCode() {
        return Question.about("El estado del código http")
                .answeredBy(
                        actor -> SerenityRest.lastResponse().getStatusCode()
                );
    }
}
