package edu.university.finals.polyclinic.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientRequest extends RegisterRequest {
    @JsonProperty("passport_id")
    private String passportId;
}
