package hospitalManagementSystem.repositories;

import hospitalManagementSystem.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, String> {
}