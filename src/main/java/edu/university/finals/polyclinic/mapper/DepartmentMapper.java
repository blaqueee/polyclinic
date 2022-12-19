package edu.university.finals.polyclinic.mapper;

import edu.university.finals.polyclinic.dto.DepartmentDto;
import edu.university.finals.polyclinic.entity.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {
    public DepartmentDto toDepartmentDto(Department department) {
        return DepartmentDto.builder()
                .id(department.getId())
                .name(department.getName())
                .build();
    }
}
