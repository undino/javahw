package org.itstep.api;

import org.itstep.models.ToDo;
import org.itstep.models.ToDoForAdd;
import org.itstep.models.UserTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@RestController
@RequestMapping(path = "/api/todolist")
public class TodoRestApi {
    private final String GET_USER_TASK = "http://localhost:8081/api/v1/todolist";
    private final String CREATE = "http://localhost:8081/api/v1/todolist";
    public static final Logger log = LoggerFactory.getLogger(TodoRestApi.class);

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public UserTask getUserTask() {
        log.debug("Into ToDoRestApi in method: 'getUserTask'");
        ResponseEntity<UserTask> responseEntity = restTemplate.getForEntity(GET_USER_TASK, UserTask.class);
        UserTask userTask = responseEntity.getBody();
        log.debug("UserTask is: " + userTask);
        HttpStatus statusCode = responseEntity.getStatusCode();
        log.debug("Status response: " + statusCode);
        return userTask;//restTemplate.getForObject(GET_USER_TASK, UserTask.class);
    }

    @GetMapping(path = "/delete")
    public void delete(@RequestParam String url){
        log.debug("Into method: delete");
        restTemplate.delete(url);
        log.debug("Out from method: delete");
    }

    @PostMapping(path = "create")
    public boolean createTodo(ToDoForAdd toDoForAdd){
        log.debug("Into method: createTodo");
        HttpEntity<ToDoForAdd> httpEntity = new HttpEntity<>(toDoForAdd);
        ToDo toDo = restTemplate.postForObject(CREATE, httpEntity, ToDo.class);
        log.debug("ToDo is: " + toDo);
        return Objects.isNull(toDo);
    }
}
