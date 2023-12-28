package com.task.task.Model.Dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.task.task.Model.Dto.common.BaseEntityDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasePersonDto extends BaseEntityDto {

    private int age;
    private String address;

    private String phoneNumber;

}
