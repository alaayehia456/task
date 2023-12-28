package com.task.task.Service;

import com.task.task.Model.Course;
import com.task.task.Model.Dto.CourseDto;
import com.task.task.Model.Dto.search.forms.CourseSearchForm;
import com.task.task.Model.Mapper.CourseMapper;
import com.task.task.dao.GenericRepository;
import com.task.task.dao.Specification.CourseSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService extends BaseService<Course, CourseDto, CourseSearchForm>{

    private final CourseMapper courseMapper;

    public CourseService(GenericRepository<Course> genericRepository, CourseMapper courseMapper) {
        super(genericRepository);
        this.courseMapper = courseMapper;
    }

    @Override
    protected Course toEntity(CourseDto object) {
        return courseMapper.toEntity(object);
    }

    @Override
    protected CourseDto toDto(Course object) {
        return courseMapper.toDto(object);
    }

    @Override
    protected List<CourseDto> toListOfDto(List<Course> list) {
        return courseMapper.toListOfDto(list);
    }

    @Override
    protected Specification<Course> buildSpecification(CourseSearchForm searchParams) {
        return CourseSpecification.search(searchParams);
    }
}
