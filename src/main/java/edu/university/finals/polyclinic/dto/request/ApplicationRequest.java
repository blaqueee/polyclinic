package edu.university.finals.polyclinic.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationRequest {
    @JsonProperty("complaint_id")
    private Long complaintId;

    @JsonProperty("disease_id")
    private Long diseaseId;
}
