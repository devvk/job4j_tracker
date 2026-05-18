package ru.job4j.mapstruct.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private int id;
    private String name;
    private String className;
}
