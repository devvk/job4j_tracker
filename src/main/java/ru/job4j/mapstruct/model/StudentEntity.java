package ru.job4j.mapstruct.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    private int id;
    private String name;
    private String classVal;
}

