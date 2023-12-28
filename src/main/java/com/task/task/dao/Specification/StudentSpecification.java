package com.task.task.dao.Specification;

import com.task.task.Model.Dto.search.forms.StudentSearchForm;
import com.task.task.Model.Dto.search.forms.TeacherSearch;
import com.task.task.Model.Student;
import com.task.task.Model.Teacher;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentSpecification {

    public static Specification<Student> search(StudentSearchForm searchForm) {
        return (Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(searchForm.getName()))
                predicates.add(cb.like(root.get("name"), "%" + searchForm.getName() + "%"));


            if (Objects.nonNull(searchForm.getPhoneNumber()))
                predicates.add(cb.equal(root.get("phoneNumber"), "%" +searchForm.getPhoneNumber() + "%"));

            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
