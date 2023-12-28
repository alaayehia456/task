package com.task.task.dao.Specification;

import com.task.task.Model.Course;
import com.task.task.Model.Dto.search.forms.CourseSearchForm;
import com.task.task.Model.Dto.search.forms.QuizSearchForm;
import com.task.task.Model.Quiz;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuizSpecification {

    public static Specification<Quiz> search(QuizSearchForm searchForm) {
        return (Root<Quiz> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(searchForm.getName()))
                predicates.add(cb.like(root.get("name"), "%" + searchForm.getName() + "%"));

            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
