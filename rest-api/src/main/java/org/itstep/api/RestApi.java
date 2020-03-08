package org.itstep.api;

import org.springframework.web.client.RestTemplate;

public abstract class RestApi<T> {
    protected RestTemplate restTemplate;

    public RestApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public abstract T getAllUsers();

}
