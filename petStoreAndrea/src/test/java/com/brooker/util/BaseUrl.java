package com.brooker.util;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;

public class BaseUrl {
    private static EnvironmentVariables environmentVariables;

    public String getUrl() {
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("environments.default.baseurl");
    }
}

