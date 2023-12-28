package com.task.task.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "QUIZ")
public class Quiz extends BaseEntity {

    private float degree;

    @ManyToOne
    @JoinColumn(name = "COURSE_ID",updatable = false,insertable = false)
    private Course course;

    @Column(name = "COURSE_ID")
    private Long courseId;
}
