package com.northcoders.demospringbootapp.model;

public class Person {
    private String name;
    private int age;
    private String email;
    private String placeOfBirth;
    private String favouriteFood;

    public Person(String name, int age, String email, String placeOfBirth, String favouriteFood) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.placeOfBirth = placeOfBirth;
        this.favouriteFood = favouriteFood;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String getName() {
        return name;
    }

}
