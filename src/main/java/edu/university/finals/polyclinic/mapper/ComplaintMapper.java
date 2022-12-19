package edu.university.finals.polyclinic.mapper;

import edu.university.finals.polyclinic.dto.ComplaintDto;
import edu.university.finals.polyclinic.dto.request.ComplaintRequest;
import edu.university.finals.polyclinic.entity.Complaint;
import edu.university.finals.polyclinic.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class ComplaintMapper {
    private final UserMapper userMapper;

    public Complaint toEntity(ComplaintRequest complaintRequest, Patient patient) {
        return Complaint.builder()
                .description(complaintRequest.getDescription())
                .patient(patient)
                .createdAt(LocalDateTime.now())
                .build();
    }

    public ComplaintDto toDto(Complaint complaint) {
        return ComplaintDto.builder()
                .id(complaint.getId())
                .description(complaint.getDescription())
                .patient(userMapper.toPatientDto(complaint.getPatient()))
                .createdAt(complaint.getCreatedAt())
                .build();
    }
}
