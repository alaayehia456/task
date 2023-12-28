package com.task.task.Model;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alaa Yeia
 * @implNote this  entity for shared attributes in humans in school
 */
@Setter
@Getter
@MappedSuperclass
public class BasePerson extends BaseEntity{

    private int age;

    private String address;

    private String phoneNumber;
}
