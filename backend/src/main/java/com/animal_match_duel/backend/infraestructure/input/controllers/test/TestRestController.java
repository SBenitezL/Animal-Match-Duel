package com.animal_match_duel.backend.infraestructure.input.controllers.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.animal_match_duel.backend.application.output.formatter.ExceptionFormatterIntPort;
import com.animal_match_duel.backend.infraestructure.input.exception.own.EntityNotFoundException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class TestRestController {
    private final ExceptionFormatterIntPort formatter;

    @GetMapping("")
    public ResponseEntity<RuntimeException> getGreeting() {
        RuntimeException res = new EntityNotFoundException("Test response");
        this.formatter.returnResponseEntityNotFound("error.entity_not_found.test");
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
    }

}
