package edu.university.finals.polyclinic.service;

import edu.university.finals.polyclinic.dto.DoctorDto;
import edu.university.finals.polyclinic.dto.PatientDto;
import edu.university.finals.polyclinic.dto.request.DoctorRequest;
import edu.university.finals.polyclinic.dto.request.PatientRequest;
import edu.university.finals.polyclinic.exception.EmailExistsException;
import edu.university.finals.polyclinic.exception.NotFoundException;
import edu.university.finals.polyclinic.mapper.UserMapper;
import edu.university.finals.polyclinic.repository.DoctorRepository;
import edu.university.finals.polyclinic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final UserMapper userMapper;


    public DoctorDto registerDoctor(DoctorRequest doctorRequest) throws EmailExistsException, NotFoundException {
        if (doctorRepository.existsByEmail(doctorRequest.getEmail()))
            throw new EmailExistsException("Doctor with email " + doctorRequest.getEmail() + " exists!");
        var doctor = userMapper.toDoctor(doctorRequest);
        var savedDoctor = doctorRepository.save(doctor);
        return userMapper.toDoctorDto(savedDoctor);
    }

    public PatientDto registerPatient(PatientRequest patientRequest) throws EmailExistsException {
        if (patientRepository.existsByEmail(patientRequest.getEmail()))
            throw new EmailExistsException("Patient with email " + patientRequest.getEmail() + " exists!");
        var patient = userMapper.toPatient(patientRequest);
        var savedPatient = patientRepository.save(patient);
        return userMapper.toPatientDto(savedPatient);
    }
}
