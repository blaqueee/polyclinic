package edu.university.finals.polyclinic.mapper;

import edu.university.finals.polyclinic.dto.ApplicationDto;
import edu.university.finals.polyclinic.entity.Application;
import edu.university.finals.polyclinic.entity.Complaint;
import edu.university.finals.polyclinic.entity.Disease;
import edu.university.finals.polyclinic.entity.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationMapper {
    private final UserMapper userMapper;
    private final DiseaseMapper diseaseMapper;

    public Application toEntity(Complaint complaint, Disease disease, Doctor doctor) {
        return Application.builder()
                .complaint(complaint)
                .doctor(doctor)
                .disease(disease)
                .createdAt(complaint.getCreatedAt())
                .build();
    }

    public ApplicationDto toDto(Application application) {
        return ApplicationDto.builder()
                .id(application.getId())
                .patient(userMapper
                        .toPatientDto(application.getComplaint().getPatient()))
                .disease(diseaseMapper.toDto(application.getDisease()))
                .createdAt(application.getCreatedAt())
                .build();
    }
}
