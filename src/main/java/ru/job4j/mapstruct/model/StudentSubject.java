package ru.job4j.mapstruct.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubject {

    private int id;
    private String name;
    private String classVal;
    private SubjectEntity subject;
}
