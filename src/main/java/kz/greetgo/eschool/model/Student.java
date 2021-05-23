package kz.greetgo.eschool.model;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {

    private Long id;
    private String name;
    private String surname;
    private int grade; // Класс школьника (1 - 11 (12))
    private String favoriteSubject;

    public Student (){}

    public Student(String name, String surname, int grade, String favoriteSubject) {
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.favoriteSubject = favoriteSubject;
    }

    public Student(Long id, String name, String surname, int grade, String favoriteSubject) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.favoriteSubject = favoriteSubject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getFavoriteSubject() {
        return favoriteSubject;
    }

    public void setFavoriteSubject(String favoriteSubject) {
        this.favoriteSubject = favoriteSubject;
    }

    @Override
    public int compareTo(Student o) {
        return this.id > o.id ? 1 : -1;
    }
}
