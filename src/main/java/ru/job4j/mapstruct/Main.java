package ru.job4j.mapstruct;

import org.mapstruct.factory.Mappers;
import ru.job4j.mapstruct.dto.DeliveryAddressDto;
import ru.job4j.mapstruct.dto.StudentDto;
import ru.job4j.mapstruct.mappers.DeliveryAddressMapper;
import ru.job4j.mapstruct.mappers.StudentMapper;
import ru.job4j.mapstruct.model.AddressEntity;
import ru.job4j.mapstruct.model.StudentEntity;

public class Main {

    public static void main(String[] args) {

        StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
        StudentEntity studentEntity = new StudentEntity(0, "entity", "junior");
        StudentDto studentDto = new StudentDto(11, "dto", "middle");

        StudentDto fromEntity = studentMapper.getModelFromEntity(studentEntity);
        System.out.println(fromEntity);

        StudentEntity fromDto = studentMapper.getEntityFromDto(studentDto);
        System.out.println(fromDto);

        DeliveryAddressMapper deliveryAddressMapper = Mappers.getMapper(DeliveryAddressMapper.class);
        AddressEntity address = new AddressEntity(100, "cityGood", "stateNew");
        DeliveryAddressDto deliveryAddressDto = deliveryAddressMapper.getDeliveryAddress(studentEntity, address);
        System.out.println(deliveryAddressDto);
    }
}
