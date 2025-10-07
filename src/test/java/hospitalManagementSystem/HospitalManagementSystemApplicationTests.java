package hospitalManagementSystem;

import hospitalManagementSystem.entities.AppointmentEntity;
import hospitalManagementSystem.entities.DoctorEntity;
import hospitalManagementSystem.entities.InsuranceEntity;
import hospitalManagementSystem.entities.PatientEntity;
import hospitalManagementSystem.repositories.AppointmentRepository;
import hospitalManagementSystem.repositories.DoctorRepository;
import hospitalManagementSystem.repositories.PatientRepository;
import hospitalManagementSystem.services.AppointmentService;
import hospitalManagementSystem.services.InsuranceService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class HospitalManagementSystemApplicationTests {
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentService appointmentService;


    @Test
    @Transactional
    @Rollback(false)
    public void insuranceServiceTest() {
        PatientEntity patient = new PatientEntity();
        patient.setEmail("user-1@gmail.com");
        patient.setName("user-1");
        patient.setBirthDate(LocalDate.of(2000, 2, 3));
        patient.setReason("reason-1");
        patient = patientRepository.save(patient);

        InsuranceEntity insurance = new InsuranceEntity();
        insurance.setName("insurance-1");
        insurance.setProvider("provider-1");
        insurance.setExpiryTime(LocalDateTime.now().plusYears(1));

        try {
            PatientEntity patientWithInsurance = insuranceService.assignInsuranceToPatient(insurance, patient.getId());
            System.out.println("Patient with insurance assigned: " + patientWithInsurance);
            System.out.println("Insurance with insurance assigned: " + insurance);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createAppointment() {
        AppointmentEntity appointment = AppointmentEntity.builder()
                .reason("Something")
                .time(LocalDateTime.of(2002, 12, 23, 0, 0))
                .build();

        DoctorEntity doctor = DoctorEntity.builder()
                .email("doctor-1@gmail.com")
                .name("doctor-1")
                .specialization("spec-1")
                .build();

        doctorRepository.save(doctor);

        var app = appointmentService.createAppointment(
                appointment,
                "b7833a19-995f-4ba8-8bb0-bd9b98d4cdb3",
                doctor.getId()
        );

        appointmentRepository.save(app);
        System.out.println(app);
    }

    @Test
    public void reAssignAppointment(){
        var appintment= appointmentService.reAssignAppointmentToDoctor("e71f7aad-a993-469a-a2d4-a993c807755c","aea402f3-179e-4b56-a1ec-d4e9684d2e46");
        appointmentRepository.save(appintment);
        System.out.println(appintment);
    }
}
