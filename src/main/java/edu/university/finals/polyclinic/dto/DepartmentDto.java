package edu.university.finals.polyclinic.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;
}
