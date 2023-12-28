package com.task.task.dao.Specification;

import com.task.task.Model.Dto.search.forms.TeacherSearch;
import com.task.task.Model.Teacher;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeacherSpecification {
    public static Specification<Teacher> search(TeacherSearch teacherSearch) {
        return (Root<Teacher> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(teacherSearch.getName()))
                predicates.add(cb.like(root.get("name"), "%" + teacherSearch.getName() + "%"));


            if (Objects.nonNull(teacherSearch.getPhoneNumber()))
                predicates.add(cb.equal(root.get("phoneNumber"), "%" +teacherSearch.getPhoneNumber() + "%"));

            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

}
