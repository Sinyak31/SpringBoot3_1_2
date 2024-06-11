package com.example.springboot3_1_2.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;


@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    @NotBlank(message = "Поле обязательное к заполнению")
    @Size(min = 2, max=30,message = "Имя должно состоять от 2 до 30 символов")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+$",message = "Имя не может содержать цифры или символы")
    private String name;
    @Column(name = "surname")
    @NotBlank(message = "Поле обязательное к заполнению")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]+(?:-[a-zA-Zа-яА-Я]+)?$",message = "Фамилия не может содержать цифры или символы кроме -")
    private String surname;
    @Column(name = "age")
    @Min(value = 0,message = "Возраст не может быть отрицательным")
    private int age;

    public User() {
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
