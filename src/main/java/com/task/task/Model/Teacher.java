package com.task.task.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TEACHER")
public class Teacher extends BasePerson{

    @OneToOne
    @JoinColumn(name = "COURSE_ID",insertable = false,updatable = false)
    private Course course;

    @Column(name = "COURSE_ID")
    private Long courseId;
}
