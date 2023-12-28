package com.task.task.controller;

import com.task.task.Model.Dto.TeacherDTO;
import com.task.task.Model.Dto.common.PageDto;
import com.task.task.Model.Dto.search.forms.TeacherSearch;
import com.task.task.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<TeacherDTO> create(@RequestBody TeacherDTO teacherDTO){
        return ResponseEntity.ok(teacherService.create(teacherDTO));
    }

    @PutMapping
    public ResponseEntity<TeacherDTO> update(@RequestBody TeacherDTO teacherDTO){
        return ResponseEntity.ok(teacherService.update(teacherDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        teacherService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<PageDto> search(@RequestBody TeacherSearch teacherSearch){
        return ResponseEntity.ok(teacherService.findListWithPagination(teacherSearch));
    }
}
