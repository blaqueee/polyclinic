package edu.university.finals.polyclinic.controller;

import edu.university.finals.polyclinic.dto.DoctorDto;
import edu.university.finals.polyclinic.dto.PatientDto;
import edu.university.finals.polyclinic.dto.request.DoctorRequest;
import edu.university.finals.polyclinic.dto.request.PatientRequest;
import edu.university.finals.polyclinic.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register/doctor")
    public ResponseEntity<DoctorDto> registerDoctor(@Valid @RequestBody DoctorRequest form) {
        return ResponseEntity.ok(userService.registerDoctor(form));
    }

    @PostMapping("/register/patient")
    public ResponseEntity<PatientDto> registerPatient(@Valid @RequestBody PatientRequest form) {
        return ResponseEntity.ok(userService.registerPatient(form));
    }
}
