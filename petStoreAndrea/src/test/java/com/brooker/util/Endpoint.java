package com.brooker.util;

public enum Endpoint {

    GET_PET("/pet/"),
    POST_PET("/pet/"),
    PUT_PET("/pet/");



    private final String endpoint;

    Endpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

}
