package edu.university.finals.polyclinic.service;

import edu.university.finals.polyclinic.dto.HistoryDto;
import edu.university.finals.polyclinic.exception.NotFoundException;
import edu.university.finals.polyclinic.mapper.HistoryMapper;
import edu.university.finals.polyclinic.repository.HistoryRepository;
import edu.university.finals.polyclinic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final PatientRepository patientRepository;
    private final HistoryMapper historyMapper;

    public List<HistoryDto> getHistoryOfPatient(Long patientId) {
        var patient = patientRepository.findById(patientId);
        if (patient.isEmpty())
            throw new NotFoundException("Patient with id " + patient + " not found!");
        var historyList = historyRepository.findAllByPatient(patient.get());
        return historyList.stream()
                .map(historyMapper::toDto)
                .collect(Collectors.toList());
    }
}
