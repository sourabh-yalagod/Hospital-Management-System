package hospitalManagementSystem.repositories;

import hospitalManagementSystem.entities.DepartmentEntity;
import hospitalManagementSystem.entities.InsuranceEntity;
import org.springframework.data.repository.Repository;

public interface DepartmentRepository extends Repository<DepartmentEntity, String> {
}