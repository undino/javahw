
package org.itstep.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "self",
    "toDo"
})
public class Links {

    @JsonProperty("self")
    private Self self;
    @JsonProperty("toDo")
    private ToDo_ toDo;

    @JsonProperty("self")
    public Self getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(Self self) {
        this.self = self;
    }

    @JsonProperty("toDo")
    public ToDo_ getToDo() {
        return toDo;
    }

    @JsonProperty("toDo")
    public void setToDo(ToDo_ toDo) {
        this.toDo = toDo;
    }

    @Override
    public String toString() {
        return "Links{" +
                "self=" + self +
                ", toDo=" + toDo +
                '}';
    }
}
