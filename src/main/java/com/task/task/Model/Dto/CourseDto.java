package com.task.task.Model.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.task.task.Model.Dto.common.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDto extends BaseEntityDto {
}
