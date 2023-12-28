package com.task.task.Model.Dto.search.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseSearchForm{
    private Integer page;
    private Integer size;
}
