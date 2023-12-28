package com.task.task.Model.Mapper;

import com.task.task.Model.Dto.StudentDto;
import com.task.task.Model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentDto studentDto);

    StudentDto toDto(Student student);

    List<StudentDto> toListOfDto(List<Student> students);
}
