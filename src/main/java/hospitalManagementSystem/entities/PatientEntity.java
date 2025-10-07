package hospitalManagementSystem.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@ToString
public class PatientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private String name;
    private LocalDate birthDate;
    private String reason;
    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Relational Fields
    @OneToOne(mappedBy = "patient", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @ToString.Exclude
    private InsuranceEntity insurance; // Owning Side on relation to insurance

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private List<AppointmentEntity> appointments = new ArrayList<>();
}
