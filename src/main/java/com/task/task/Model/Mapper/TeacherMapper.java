package com.task.task.Model.Mapper;


import com.task.task.Model.Dto.TeacherDTO;
import com.task.task.Model.Teacher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper{

    Teacher toEntity(TeacherDTO teacherDTO);

    TeacherDTO toDto(Teacher teacher);

    List<TeacherDTO> toListOfDto(List<Teacher> teachers);
}
