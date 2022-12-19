package edu.university.finals.polyclinic.service;

import edu.university.finals.polyclinic.dto.ApplicationDto;
import edu.university.finals.polyclinic.dto.request.ApplicationRequest;
import edu.university.finals.polyclinic.entity.Application;
import edu.university.finals.polyclinic.entity.Doctor;
import edu.university.finals.polyclinic.entity.User;
import edu.university.finals.polyclinic.exception.NotFoundException;
import edu.university.finals.polyclinic.mapper.ApplicationMapper;
import edu.university.finals.polyclinic.mapper.HistoryMapper;
import edu.university.finals.polyclinic.repository.ApplicationRepository;
import edu.university.finals.polyclinic.repository.ComplaintRepository;
import edu.university.finals.polyclinic.repository.DiseaseRepository;
import edu.university.finals.polyclinic.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final HistoryRepository historyRepository;
    private final DiseaseRepository diseaseRepository;
    private final ComplaintRepository complaintRepository;
    private final ApplicationMapper applicationMapper;
    private final HistoryMapper historyMapper;

    public List<ApplicationDto> getAllByDoctor(User user) {
        var applications = applicationRepository.findAllByDoctor((Doctor) user);
        return applications.stream()
                .map(applicationMapper::toDto)
                .collect(Collectors.toList());
    }

    public ApplicationDto createApplication(ApplicationRequest form, User user) throws NotFoundException {
        var complaint = complaintRepository.findById(form.getComplaintId());
        if (complaint.isEmpty())
            throw new NotFoundException("Complaint with id " + form.getComplaintId() + " not found!");
        var disease = diseaseRepository.findById(form.getDiseaseId());
        if (disease.isEmpty())
            throw new NotFoundException("Disease with id " + form.getDiseaseId() + " not found!");
        var application = applicationMapper.toEntity(complaint.get(), disease.get(), (Doctor) user);
        var saved = applicationRepository.save(application);
        createDiseaseHistory(application);
        return applicationMapper.toDto(saved);
    }

    private void createDiseaseHistory(Application application) {
        var history = historyMapper.toEntity(application);
        historyRepository.save(history);
    }
}
