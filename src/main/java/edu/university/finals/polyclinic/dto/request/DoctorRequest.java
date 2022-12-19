package edu.university.finals.polyclinic.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorRequest extends RegisterRequest {
    @JsonProperty("title")
    private String title;

    @JsonProperty("specialization")
    private String specialization;

    @JsonProperty("experience")
    private Integer experience;

    @JsonProperty("department_id")
    private Long departmentId;
}
