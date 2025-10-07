package hospitalManagementSystem.repositories;

import hospitalManagementSystem.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, String> {
}