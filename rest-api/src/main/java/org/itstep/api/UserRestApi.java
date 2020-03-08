package org.itstep.api;

import org.itstep.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public class UserRestApi extends RestApi<Page> {

    private final String GET_USERS = "https://reqres.in/api/users?per_page=100";

    @Autowired
    public UserRestApi(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    @GetMapping
    public Page getAllUsers() {
        Page page = restTemplate.getForObject(GET_USERS, Page.class);
        System.out.println(page);
        return page;
    }
}



