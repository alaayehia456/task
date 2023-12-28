package com.task.task.Model.Mapper;

import com.task.task.Model.Dto.QuizDto;
import com.task.task.Model.Quiz;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuizMapper{

    Quiz toEntity(QuizDto quizDto);

    QuizDto toDto(Quiz quiz);

    List<QuizDto> toListOfDto(List<Quiz> quizList);

}
