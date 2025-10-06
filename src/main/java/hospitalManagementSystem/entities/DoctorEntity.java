package hospitalManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "doctors")
public class DoctorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "specialization")
    private String specialization;

    // Relational Fields
    @OneToMany(mappedBy = "doctor")
    private List<AppointmentEntity> appointments = new ArrayList<>();

    @ManyToMany(mappedBy = "doctors")
    private Set<DepartmentEntity> departments = new HashSet<>();
}
