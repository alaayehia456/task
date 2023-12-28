package com.task.task.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "STUDENT")
public class Student extends BasePerson{

    @ManyToMany
    @JoinTable(
            name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "COURSE_ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID")
    )
    private Set<Course> courses;
}
