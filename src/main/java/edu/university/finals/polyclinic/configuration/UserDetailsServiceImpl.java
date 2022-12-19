package edu.university.finals.polyclinic.configuration;

import edu.university.finals.polyclinic.repository.DoctorRepository;
import edu.university.finals.polyclinic.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var doctor = doctorRepository.findByEmail(email);
        var patient = patientRepository.findByEmail(email);
        if (doctor.isPresent()) return doctor.get();
        if (patient.isPresent()) return patient.get();
        throw new UsernameNotFoundException("User with email " + email + " not found!");
    }
}
