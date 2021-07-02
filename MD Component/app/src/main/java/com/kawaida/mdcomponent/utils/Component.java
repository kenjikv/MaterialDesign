package com.kawaida.mdcomponent.utils;

import java.util.Objects;

public class Component {

    private String name;
    private int photoRes;
    private int type; //Static o Scroll

    public Component() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoRes() {
        return photoRes;
    }

    public void setPhotoRes(int photoRes) {
        this.photoRes = photoRes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return photoRes == component.photoRes &&
                type == component.type &&
                Objects.equals(name, component.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, photoRes, type);
    }
}
