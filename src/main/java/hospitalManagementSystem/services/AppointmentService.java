package hospitalManagementSystem.services;

import hospitalManagementSystem.entities.AppointmentEntity;
import hospitalManagementSystem.entities.DoctorEntity;
import hospitalManagementSystem.entities.PatientEntity;
import hospitalManagementSystem.repositories.AppointmentRepository;
import hospitalManagementSystem.repositories.DoctorRepository;
import hospitalManagementSystem.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public AppointmentEntity createAppointment(AppointmentEntity appointment, String patientId, String doctorId) {
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow();
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        // to maintain by-directional consistency
        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        return appointmentRepository.save(appointment);
    }

    public AppointmentEntity reAssignAppointmentToDoctor(String assingmentId, String doctorId) {
        AppointmentEntity appointment = appointmentRepository.findById(assingmentId).orElseThrow();
        DoctorEntity doctor = doctorRepository.findById(doctorId).orElseThrow();
        doctor.getAppointments().add(appointment);
        appointment.setDoctor(doctor);
        return appointment;
    }
}
