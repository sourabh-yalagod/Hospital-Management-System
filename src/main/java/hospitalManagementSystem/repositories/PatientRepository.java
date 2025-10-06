package hospitalManagementSystem.repositories;

import hospitalManagementSystem.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<PatientEntity, String> {
}