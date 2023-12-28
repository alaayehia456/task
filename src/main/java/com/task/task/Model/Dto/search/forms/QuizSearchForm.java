package com.task.task.Model.Dto.search.forms;

import com.task.task.Model.Dto.common.BaseEntityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizSearchForm extends BaseSearchForm {
    private float degree;

    private String name;
}
