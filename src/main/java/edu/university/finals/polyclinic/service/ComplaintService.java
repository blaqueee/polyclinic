package edu.university.finals.polyclinic.service;

import edu.university.finals.polyclinic.dto.ComplaintDto;
import edu.university.finals.polyclinic.dto.request.ComplaintRequest;
import edu.university.finals.polyclinic.entity.Patient;
import edu.university.finals.polyclinic.entity.User;
import edu.university.finals.polyclinic.mapper.ComplaintMapper;
import edu.university.finals.polyclinic.repository.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ComplaintService {
    private final ComplaintRepository complaintRepository;
    private final ComplaintMapper complaintMapper;

    public ComplaintDto createComplaint(ComplaintRequest form, User user) {
        var complaint = complaintMapper.toEntity(form, (Patient) user);
        var saved = complaintRepository.save(complaint);
        return complaintMapper.toDto(saved);
    }
}
