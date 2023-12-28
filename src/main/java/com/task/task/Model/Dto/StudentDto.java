package com.task.task.Model.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.task.task.Model.Course;
import com.task.task.Model.Dto.common.BaseEntityDto;
import com.task.task.Model.Dto.common.BasePersonDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import java.util.Set;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto extends BasePersonDto {

    @ReadOnlyProperty
    private Set<CourseDto> courses;
}
