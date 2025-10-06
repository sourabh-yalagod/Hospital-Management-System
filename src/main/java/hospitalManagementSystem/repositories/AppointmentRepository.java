package hospitalManagementSystem.repositories;

import hospitalManagementSystem.entities.AppointmentEntity;
import org.springframework.data.repository.Repository;

public interface AppointmentRepository extends Repository<AppointmentEntity, String> {
}