
package org.itstep.models;

import java.time.LocalDateTime;

public class ToDoForAdd {

    private String title;
    private String description;
    private String created;
    private String lastUpdate;
    private String priority;
    private Boolean done;

    public ToDoForAdd(String title, String description, String priority, Boolean done) {
        this.title = title;
        this.description = description;
        this.created = LocalDateTime.now().toString();
        this.lastUpdate = LocalDateTime.now().toString();
        this.priority = priority;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

}
