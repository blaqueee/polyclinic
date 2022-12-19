package edu.university.finals.polyclinic.mapper;

import edu.university.finals.polyclinic.dto.DiseaseDto;
import edu.university.finals.polyclinic.entity.Disease;
import org.springframework.stereotype.Component;

@Component
public class DiseaseMapper {
    public DiseaseDto toDto(Disease disease) {
        return DiseaseDto.builder()
                .id(disease.getId())
                .name(disease.getName())
                .cause(disease.getCause())
                .build();
    }
}
