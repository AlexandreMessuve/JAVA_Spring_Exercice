package com.example.exercice03.controller;

import com.example.exercice03.dto.candidate.CandidateDtoGet;
import com.example.exercice03.dto.candidate.CandidateDtoPost;
import com.example.exercice03.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @GetMapping("/candidate")
    public ResponseEntity<List<CandidateDtoGet>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.findAll());
    }

    @GetMapping("/candidate/{id}")
    public ResponseEntity<CandidateDtoGet> getCandidateById(@PathVariable int id) {
        return ResponseEntity.ok(candidateService.findById(id));
    }

    @PostMapping("/candidate/add")
    public ResponseEntity<CandidateDtoGet> addCandidate(@RequestBody CandidateDtoPost candidateDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.create(candidateDtoPost));
    }

    @PutMapping("/candidate/{id}")
    public ResponseEntity<CandidateDtoGet> updateCandidate(@PathVariable int id, @RequestBody CandidateDtoPost candidateDtoPost) {
        return ResponseEntity.ok(candidateService.update(id, candidateDtoPost));
    }

    @DeleteMapping("/candidate/{id}")
    public ResponseEntity<String> deleteCandidate(@PathVariable int id) {
        candidateService.delete(id);
        return ResponseEntity.ok("Candidate with id " + id + " deleted successfully");
    }
}
