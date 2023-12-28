package com.task.task.controller;

import com.task.task.Model.Dto.CourseDto;
import com.task.task.Model.Dto.TeacherDTO;
import com.task.task.Model.Dto.common.PageDto;
import com.task.task.Model.Dto.search.forms.CourseSearchForm;
import com.task.task.Model.Dto.search.forms.TeacherSearch;
import com.task.task.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @PostMapping
    public ResponseEntity<CourseDto> create(@RequestBody CourseDto courseDto){
        return ResponseEntity.ok(courseService.create(courseDto));
    }

    @PutMapping
    public ResponseEntity<CourseDto> update(@RequestBody CourseDto courseDto){
        return ResponseEntity.ok(courseService.update(courseDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<PageDto> search(@RequestBody CourseSearchForm searchForm){
        return ResponseEntity.ok(courseService.findListWithPagination(searchForm));
    }
}
