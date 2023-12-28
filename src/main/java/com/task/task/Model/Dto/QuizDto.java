package com.task.task.Model.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.task.task.Model.Course;
import com.task.task.Model.Dto.common.BaseEntityDto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuizDto extends BaseEntityDto {

    private float degree;

    @ReadOnlyProperty
    private CourseDto course;

    private Long courseId;
}
