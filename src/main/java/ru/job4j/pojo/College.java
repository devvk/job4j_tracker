package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setSurname("Ivanov");
        s1.setName("Ivan");
        s1.setPatronymic("Ivanovich");
        s1.setGroup("Engineers");
        s1.setCreated(new Date());
        System.out.println("surname: " + s1.getSurname());
        System.out.println("name: " + s1.getName());
        System.out.println("patronymic: " + s1.getPatronymic());
        System.out.println("group: " + s1.getGroup());
        System.out.println("created: " + s1.getCreated());
    }
}
