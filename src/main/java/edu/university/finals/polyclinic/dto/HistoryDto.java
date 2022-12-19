package edu.university.finals.polyclinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoryDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("disease")
    private DiseaseDto disease;

    @JsonProperty("time")
    private LocalDateTime time;
}
