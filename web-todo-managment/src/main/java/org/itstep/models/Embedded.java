
package org.itstep.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "toDos"
})
public class Embedded {

    @JsonProperty("toDos")
    private List<ToDo> toDos = null;


    @JsonProperty("toDos")
    public List<ToDo> getToDos() {
        return toDos;
    }

    @JsonProperty("toDos")
    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }


    @Override
    public String toString() {
        return "Embedded{" +
                "toDos=" + toDos +
                '}';
    }
}
