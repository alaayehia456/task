package com.task.task.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "COURSE")
public class Course extends BaseEntity{

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @OneToOne(mappedBy = "course")
    private Teacher  teacher;
}
