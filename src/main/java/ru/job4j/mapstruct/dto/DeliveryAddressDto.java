package ru.job4j.mapstruct.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAddressDto {

    private String name;
    private int houseNumber;
    private String city;
    private String state;
}
