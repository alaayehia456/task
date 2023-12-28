package com.task.task.Service;

import com.task.task.Model.Dto.QuizDto;
import com.task.task.Model.Dto.search.forms.QuizSearchForm;
import com.task.task.Model.Mapper.QuizMapper;
import com.task.task.Model.Quiz;
import com.task.task.dao.GenericRepository;
import com.task.task.dao.Specification.QuizSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService extends BaseService<Quiz, QuizDto, QuizSearchForm>{


    private final QuizMapper quizMapper;

    public QuizService(GenericRepository<Quiz> genericRepository, QuizMapper quizMapper) {
        super(genericRepository);
        this.quizMapper = quizMapper;
    }

    @Override
    protected Quiz toEntity(QuizDto object) {
        return quizMapper.toEntity(object);
    }

    @Override
    protected QuizDto toDto(Quiz object) {
        return quizMapper.toDto(object);
    }

    @Override
    protected List<QuizDto> toListOfDto(List<Quiz> list) {
        return quizMapper.toListOfDto(list);
    }

    @Override
    protected Specification<Quiz> buildSpecification(QuizSearchForm searchParams) {
        return QuizSpecification.search(searchParams);
    }
}
