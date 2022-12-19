package edu.university.finals.polyclinic.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "doctors")
public class Doctor extends User {
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "experience_in_years", nullable = false)
    private Integer experience;

    @ManyToOne
    private Department department;
}
