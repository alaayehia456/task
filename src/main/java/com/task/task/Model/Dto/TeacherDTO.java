package com.task.task.Model.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.task.task.Model.Course;
import com.task.task.Model.Dto.common.BaseEntityDto;
import com.task.task.Model.Dto.common.BasePersonDto;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDTO extends BasePersonDto {

    @ReadOnlyProperty
    private CourseDto course;

    private Long courseId;
}
