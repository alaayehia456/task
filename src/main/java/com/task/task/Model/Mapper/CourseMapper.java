package com.task.task.Model.Mapper;

import com.task.task.Model.Course;
import com.task.task.Model.Dto.CourseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toDto(Course course);

    Course toEntity(CourseDto courseDto);

    List<CourseDto> toListOfDto(List<Course>  courses);

}
