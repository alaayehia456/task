package com.task.task.Service;

import com.task.task.Model.Dto.StudentDto;
import com.task.task.Model.Dto.search.forms.StudentSearchForm;
import com.task.task.Model.Mapper.StudentMapper;
import com.task.task.Model.Student;
import com.task.task.dao.GenericRepository;
import com.task.task.dao.Specification.StudentSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService extends BaseService<Student, StudentDto, StudentSearchForm>{

    private final StudentMapper  studentMapper;

    public StudentService(GenericRepository<Student> genericRepository, StudentMapper studentMapper) {
        super(genericRepository);
        this.studentMapper = studentMapper;
    }

    @Override
    protected Student toEntity(StudentDto object) {
        return studentMapper.toEntity(object);
    }

    @Override
    protected StudentDto toDto(Student object) {
        return studentMapper.toDto(object);
    }

    @Override
    protected List<StudentDto> toListOfDto(List<Student> list) {
        return studentMapper.toListOfDto(list);
    }

    @Override
    protected Specification<Student> buildSpecification(StudentSearchForm searchParams) {
        return StudentSpecification.search(searchParams);
    }
}
