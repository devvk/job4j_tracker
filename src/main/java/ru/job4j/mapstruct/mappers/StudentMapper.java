package ru.job4j.mapstruct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.mapstruct.dto.StudentDto;
import ru.job4j.mapstruct.model.StudentEntity;

@Mapper
public interface StudentMapper {

    @Mapping(target = "className", source = "classVal")
    StudentDto getModelFromEntity(StudentEntity student);

    @Mapping(target = "classVal", source = "className")
    StudentEntity getEntityFromDto(StudentDto studentDto);
}
