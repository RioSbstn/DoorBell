package com.example.absensinodemcufirebase;

public class User {
    private String idcard, name, nim, number;

    public User() {
    }

    public User(String idcard, String name, String nim) {
        this.idcard = idcard;
        this.name = name;
        this.nim = nim;
        this.number = number;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public String getNumber() {
        return number;
    }
}
