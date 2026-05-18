package ru.job4j.mapstruct.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    private int houseNo;
    private String city;
    private String state;
}
