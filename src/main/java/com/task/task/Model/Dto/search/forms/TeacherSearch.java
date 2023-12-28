package com.task.task.Model.Dto.search.forms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSearch extends BaseSearchForm{

    private String name;

    private int age;

    private String address;

    private String phoneNumber;
}
