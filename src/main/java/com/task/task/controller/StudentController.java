package com.task.task.controller;

import com.task.task.Model.Dto.StudentDto;
import com.task.task.Model.Dto.TeacherDTO;
import com.task.task.Model.Dto.common.PageDto;
import com.task.task.Model.Dto.search.forms.StudentSearchForm;
import com.task.task.Model.Dto.search.forms.TeacherSearch;
import com.task.task.Service.StudentService;
import com.task.task.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.create(studentDto));
    }

    @PutMapping
    public ResponseEntity<StudentDto> update(@RequestBody StudentDto studentDto){
        return ResponseEntity.ok(studentService.update(studentDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<PageDto> search(@RequestBody StudentSearchForm  searchForm){
        return ResponseEntity.ok(studentService.findListWithPagination(searchForm));
    }
}
