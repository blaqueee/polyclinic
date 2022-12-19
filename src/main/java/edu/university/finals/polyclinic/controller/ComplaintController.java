package edu.university.finals.polyclinic.controller;

import edu.university.finals.polyclinic.dto.ComplaintDto;
import edu.university.finals.polyclinic.dto.request.ComplaintRequest;
import edu.university.finals.polyclinic.entity.User;
import edu.university.finals.polyclinic.service.ComplaintService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/complaint")
@RequiredArgsConstructor
public class ComplaintController {
    private final ComplaintService complaintService;

    @PostMapping
    public ResponseEntity<ComplaintDto> complain(@Valid @RequestBody ComplaintRequest form,
                                                 @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(complaintService.createComplaint(form, user));
    }
}
