package edu.university.finals.polyclinic.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApplicationRequest {
    @JsonProperty("complaint_id")
    @NotNull
    private Long complaintId;

    @JsonProperty("disease_id")
    @NotNull
    private Long diseaseId;
}
