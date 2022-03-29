package com.knoldus.codeinsights.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

    private String full_name;
    private String type;
    private String name;
    private String uuid;

    public Repository(String full_name, String type, String name, String uuid) {
        this.full_name = full_name;
        this.type = type;
        this.name = name;
        this.uuid = uuid;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    @Override
    public String toString() {
        return "Repository{" +
                "full_name='" + full_name + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
