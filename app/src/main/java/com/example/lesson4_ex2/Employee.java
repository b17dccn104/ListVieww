package com.example.lesson4_ex2;

public class Employee {
    private int id;
    private String name;
    private boolean sex;

    public Employee() {
    }

    public Employee(int id, String name, boolean sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMale() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
