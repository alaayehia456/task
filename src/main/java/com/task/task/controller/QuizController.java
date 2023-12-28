package com.task.task.controller;

import com.task.task.Model.Dto.QuizDto;
import com.task.task.Model.Dto.StudentDto;
import com.task.task.Model.Dto.common.PageDto;
import com.task.task.Model.Dto.search.forms.QuizSearchForm;
import com.task.task.Model.Dto.search.forms.StudentSearchForm;
import com.task.task.Model.Quiz;
import com.task.task.Service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @PostMapping
    public ResponseEntity<QuizDto> create(@RequestBody QuizDto quizDto){
        return ResponseEntity.ok(quizService.create(quizDto));
    }

    @PutMapping
    public ResponseEntity<QuizDto> update(@RequestBody QuizDto quizDto){
        return ResponseEntity.ok(quizService.update(quizDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(quizService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        quizService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<PageDto> search(@RequestBody QuizSearchForm searchForm){
        return ResponseEntity.ok(quizService.findListWithPagination(searchForm));
    }
}
