package com.task.task.Service;

import com.task.task.Model.Dto.TeacherDTO;
import com.task.task.Model.Dto.search.forms.TeacherSearch;
import com.task.task.Model.Mapper.TeacherMapper;
import com.task.task.Model.Teacher;
import com.task.task.dao.GenericRepository;
import com.task.task.dao.Specification.TeacherSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService extends BaseService<Teacher, TeacherDTO, TeacherSearch>{


    private final TeacherMapper teacherMapper;

    public TeacherService(GenericRepository<Teacher> genericRepository, TeacherMapper teacherMapper) {
        super(genericRepository);
        this.teacherMapper = teacherMapper;
    }

    @Override
    protected Teacher toEntity(TeacherDTO object) {
        return teacherMapper.toEntity(object);
    }

    @Override
    protected TeacherDTO toDto(Teacher object) {
        return teacherMapper.toDto(object);
    }

    @Override
    protected List<TeacherDTO> toListOfDto(List<Teacher> list) {
        return teacherMapper.toListOfDto(list);
    }

    @Override
    protected Specification<Teacher> buildSpecification(TeacherSearch searchParams) {
        return TeacherSpecification.search(searchParams);
    }
}
