package com.task.task.Model.Dto.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageDto {

    private Object data;

    private long totalElements;

    private long totalPage;
}
