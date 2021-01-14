package com.example.menu.Classes;

public class MenuItem {
    private String title;
    private int code;
    private String id;

    public MenuItem() {
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCode() {
        return code;
    }
}
