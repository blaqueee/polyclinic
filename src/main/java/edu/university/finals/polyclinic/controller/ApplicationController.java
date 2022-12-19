package edu.university.finals.polyclinic.controller;

import edu.university.finals.polyclinic.dto.ApplicationDto;
import edu.university.finals.polyclinic.dto.request.ApplicationRequest;
import edu.university.finals.polyclinic.entity.User;
import edu.university.finals.polyclinic.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(@Valid @RequestBody ApplicationRequest form,
                                                            @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(applicationService.createApplication(form, user));
    }
}
