package ru.job4j.mapstruct.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjectDto {

    private int id;
    private String name;
    private String className;
    private String subject;
}
