package org.itstep.entity;

import java.util.Objects;

public class ToDo implements Comparable<ToDo>{
    int id;
    private String shortDescription;
    private String longDescription;
    private String creat;
    private String start;
    private String end;
    private int categoryId;
    private int statusId;

    public String getCreat() {
        return creat;
    }

    public void setCreat(String creat) {
        this.creat = creat;
    }

    public ToDo(String shortDescription, String longDescription, String start, String end, int categoryId, int statusId) {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.start = start;
        this.end = end;
        this.categoryId = categoryId;
        this.statusId = statusId;
    }

    public ToDo(int id, String shortDescription, String longDescription, String creat, String start, String end, int categoryId, int statusId) {
        this(shortDescription, longDescription, start, end, categoryId, statusId);
        this.id = id;
        this.creat = creat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "TodDo{" +
                "shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", categoryId=" + categoryId +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDo todDo = (ToDo) o;
        return Objects.equals(shortDescription, todDo.shortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortDescription);
    }

    @Override
    public int compareTo(ToDo o) {
        return this.getCategoryId() - o.getCategoryId();
    }
}
