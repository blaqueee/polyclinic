package edu.university.finals.polyclinic.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorRequest extends RegisterRequest {
    @JsonProperty("title")
    @NotBlank
    private String title;

    @JsonProperty("specialization")
    @NotBlank
    private String specialization;

    @JsonProperty("experience")
    @NotNull
    private Integer experience;

    @JsonProperty("department_id")
    @NotNull
    private Long departmentId;
}
