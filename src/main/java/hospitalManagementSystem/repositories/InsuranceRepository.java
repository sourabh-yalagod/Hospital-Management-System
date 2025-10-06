package hospitalManagementSystem.repositories;

import hospitalManagementSystem.entities.InsuranceEntity;
import hospitalManagementSystem.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface InsuranceRepository extends JpaRepository<InsuranceEntity, String> {
    PatientEntity findPatientById(String patientId);
}