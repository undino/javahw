
package org.itstep.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "title",
    "description",
    "created",
    "lastUpdate",
    "priority",
    "done",
    "_links"
})
public class ToDo {

    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("created")
    private String created;
    @JsonProperty("lastUpdate")
    private String lastUpdate;
    @JsonProperty("priority")
    private String priority;
    @JsonProperty("done")
    private Boolean done;
    @JsonProperty("_links")
    private Links links;

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("lastUpdate")
    public String getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty("lastUpdate")
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @JsonProperty("priority")
    public String getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(String priority) {
        this.priority = priority;
    }

    @JsonProperty("done")
    public Boolean getDone() {
        return done;
    }

    @JsonProperty("done")
    public void setDone(Boolean done) {
        this.done = done;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }


    @Override
    public String toString() {
        return "ToDo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", priority='" + priority + '\'' +
                ", done=" + done +
                ", links=" + links +
                '}';
    }
}
