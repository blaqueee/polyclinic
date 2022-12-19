package edu.university.finals.polyclinic.repository;

import edu.university.finals.polyclinic.entity.History;
import edu.university.finals.polyclinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    List<History> findAllByPatient(Patient patient);
}
