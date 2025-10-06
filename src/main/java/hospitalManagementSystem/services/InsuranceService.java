package hospitalManagementSystem.services;

import hospitalManagementSystem.entities.InsuranceEntity;
import hospitalManagementSystem.entities.PatientEntity;
import hospitalManagementSystem.repositories.InsuranceRepository;
import hospitalManagementSystem.repositories.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final PatientRepository patientRepository;
    private final InsuranceRepository insuranceRepository;

    public PatientEntity assignInsuranceToPatient(InsuranceEntity insurance, String patientId) throws Exception {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow(() -> new EntityNotFoundException("Patient Not Found"));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        insuranceRepository.save(insurance);
        return patient;
    }

}
