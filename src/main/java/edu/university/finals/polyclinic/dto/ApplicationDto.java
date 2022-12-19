package edu.university.finals.polyclinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("patient")
    private PatientDto patient;

    @JsonProperty("disease")
    private DiseaseDto disease;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

}
