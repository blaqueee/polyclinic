package edu.university.finals.polyclinic.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Complaint complaint;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Disease disease;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
