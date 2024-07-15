package com.example.exercice03.service;

import com.example.exercice03.dto.candidate.CandidateDtoGet;
import com.example.exercice03.dto.candidate.CandidateDtoPost;
import com.example.exercice03.entity.Candidate;
import com.example.exercice03.exception.NotFoundException;
import com.example.exercice03.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CandidateService implements BaseService<CandidateDtoGet, CandidateDtoPost> {


    private final CandidateRepository candidateRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }



    @Override
    public CandidateDtoGet create(CandidateDtoPost candidateDtoPost) {
        Candidate candidate = Candidate.builder()
                .firstname(candidateDtoPost.getFirstname())
                .lastname(candidateDtoPost.getLastname())
                .address(candidateDtoPost.getAddress())
                .birthday(LocalDate.parse(candidateDtoPost.getBirthdayStr(), formatter))
                .phone(candidateDtoPost.getPhone())
                .email(candidateDtoPost.getEmail())
                .observation(candidateDtoPost.getObservation())
                .skill(candidateDtoPost.getSkill())
                .rating(candidateDtoPost.getRating())
                .jobInterviewDate(LocalDateTime.parse(candidateDtoPost.getJobInterviewDateStr(), dateTimeFormatter))
                .technicalArea(candidateDtoPost.getTechnicalArea())
                .build();
        candidateRepository.save(candidate);
        return candidateToCandidateDtoGet(candidate);
    }

    @Override
    public CandidateDtoGet update(int id, CandidateDtoPost candidateDtoPost) {
        Candidate candidate = getById(id);
        candidate.setFirstname(candidateDtoPost.getFirstname());
        candidate.setLastname(candidateDtoPost.getLastname());
        candidate.setEmail(candidateDtoPost.getEmail());
        candidate.setPhone(candidateDtoPost.getPhone());
        candidate.setAddress(candidateDtoPost.getAddress());
        candidate.setBirthday(LocalDate.parse(candidateDtoPost.getBirthdayStr(), formatter));
        candidate.setObservation(candidateDtoPost.getObservation());
        candidate.setSkill(candidateDtoPost.getSkill());
        candidate.setRating(candidateDtoPost.getRating());
        candidate.setTechnicalArea(candidate.getTechnicalArea());
        candidate.setJobInterviewDate(LocalDateTime.parse(candidateDtoPost.getJobInterviewDateStr(), dateTimeFormatter));
        candidateRepository.save(candidate);
        return candidateToCandidateDtoGet(candidate);
    }

    @Override
    public boolean delete(int id) {
        candidateRepository.delete(getById(id));
        return true;
    }

    @Override
    public CandidateDtoGet findById(int id) {
        return candidateToCandidateDtoGet(getById(id));
    }

    @Override
    public List<CandidateDtoGet> findAll() {
        return candidateListToCandidateDtoGetList(candidateRepository.findAll());
    }

    public Candidate getById(Integer id) {
        return candidateRepository.findById(id).orElseThrow(() -> new NotFoundException(id.toString()));
    }
    public CandidateDtoGet candidateToCandidateDtoGet(Candidate candidate) {
        return CandidateDtoGet.builder()
                .id(candidate.getId())
                .firstname(candidate.getFirstname())
                .lastname(candidate.getLastname())
                .email(candidate.getEmail())
                .address(candidate.getAddress())
                .birthday(candidate.getBirthday())
                .phone(candidate.getPhone())
                .observation(candidate.getObservation())
                .skill(candidate.getSkill())
                .rating(candidate.getRating())
                .technicalArea(candidate.getTechnicalArea())
                .jobInterviewDate(candidate.getJobInterviewDate())
                .build();
    }

    public List<CandidateDtoGet> candidateListToCandidateDtoGetList(List<Candidate> candidates) {
        return candidates.stream().map(this::candidateToCandidateDtoGet).collect(Collectors.toList());
    }
}
