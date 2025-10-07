package hospitalManagementSystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
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
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<AppointmentEntity> appointments = new ArrayList<>();

    @ManyToMany(mappedBy = "doctors", fetch = FetchType.LAZY)
    private Set<DepartmentEntity> departments = new HashSet<>();
}
