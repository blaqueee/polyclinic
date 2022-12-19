package edu.university.finals.polyclinic.mapper;

import edu.university.finals.polyclinic.dto.HistoryDto;
import edu.university.finals.polyclinic.entity.Application;
import edu.university.finals.polyclinic.entity.History;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HistoryMapper {
    private final DiseaseMapper diseaseMapper;

    public History toEntity(Application application) {
        return History.builder()
                .patient(application.getComplaint().getPatient())
                .disease(application.getDisease())
                .time(application.getComplaint().getCreatedAt())
                .build();
    }

    public HistoryDto toDto(History history) {
        return HistoryDto.builder()
                .id(history.getId())
                .disease(diseaseMapper.toDto(history.getDisease()))
                .time(history.getTime())
                .build();
    }
}
