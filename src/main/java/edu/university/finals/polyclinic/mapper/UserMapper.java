package edu.university.finals.polyclinic.mapper;

import edu.university.finals.polyclinic.dto.DoctorDto;
import edu.university.finals.polyclinic.dto.PatientDto;
import edu.university.finals.polyclinic.dto.request.DoctorRequest;
import edu.university.finals.polyclinic.dto.request.PatientRequest;
import edu.university.finals.polyclinic.dto.request.RegisterRequest;
import edu.university.finals.polyclinic.entity.Doctor;
import edu.university.finals.polyclinic.entity.Patient;
import edu.university.finals.polyclinic.entity.Role;
import edu.university.finals.polyclinic.entity.User;
import edu.university.finals.polyclinic.exception.NotFoundException;
import edu.university.finals.polyclinic.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    private final PasswordEncoder encoder;
    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    public DoctorDto toDoctorDto(Doctor doctor) {
        return DoctorDto.builder()
                .id(doctor.getId())
                .firstName(doctor.getFirstName())
                .middleName(doctor.getMiddleName())
                .lastName(doctor.getLastName())
                .address(doctor.getAddress())
                .email(doctor.getEmail())
                .title(doctor.getTitle())
                .specialization(doctor.getSpecialization())
                .experience(doctor.getExperience())
                .department(departmentMapper.toDepartmentDto(doctor.getDepartment()))
                .build();
    }

    public Doctor toDoctor(DoctorRequest form) throws NotFoundException {
        var department = departmentRepository.findById(form.getDepartmentId());
        if (department.isEmpty())
            throw new NotFoundException("Department with id " + form.getDepartmentId() + " not found!");
        Doctor doctor = Doctor.builder()
                .title(form.getTitle())
                .specialization(form.getSpecialization())
                .experience(form.getExperience())
                .department(department.get())
                .build();
        setProperties(doctor, form);
        doctor.setRole(Role.ROLE_DOCTOR);

        return doctor;
    }

    public Patient toPatient(PatientRequest form) {
        Patient patient = Patient.builder()
                .passportId(form.getPassportId())
                .build();
        setProperties(patient, form);
        patient.setRole(Role.ROLE_USER);

        return patient;
    }

    public PatientDto toPatientDto(Patient patient) {
        return PatientDto.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .middleName(patient.getMiddleName())
                .lastName(patient.getLastName())
                .address(patient.getAddress())
                .email(patient.getEmail())
                .passportId(patient.getPassportId())
                .build();
    }

    public void setProperties(User user, RegisterRequest form) {
        user.setFirstName(form.getFirstName());
        user.setMiddleName(form.getMiddleName());
        user.setLastName(form.getLastName());
        user.setAddress(form.getAddress());
        user.setEmail(form.getEmail());
        user.setPassword(encoder.encode(form.getPassword()));
    }
}
