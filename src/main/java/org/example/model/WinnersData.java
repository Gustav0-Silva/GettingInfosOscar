package org.example.model;

public class WinnersData {
    private int id;
    private int awardYear;
    private int age;
    private String name;
    private String movie;
    private char sex;
    private int award;

    public int getAward() {
        return award;
    }

    public WinnersData(int id, int awardYear, int age, String name, String movie, char sex, int award) {
        this.id = id;
        this.awardYear = awardYear;
        this.age = age;
        this.name = name;
        this.movie = movie;
        this.sex = sex;
        this.award = award;
    }

    public int getId() {
        return id;
    }

    public int getAwardYear() {
        return awardYear;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMovie() {
        return movie;
    }

    public char getSex() {
        return sex;
    }
}
