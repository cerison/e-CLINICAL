package miu.cs.ads_datapersisitence.repository;

import jakarta.transaction.Transactional;
import miu.cs.ads_datapersisitence.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE appointments SET dentist = :dentistId WHERE id = :appointmentId", nativeQuery = true)
    public void updateDentistAppointment(Integer appointmentId,Integer dentistId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE appointments SET surgery = :surgeryId WHERE id = :appointmentId", nativeQuery = true)
    public void updateSurgeryAppointment(Integer appointmentId,Integer surgeryId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE appointments SET status = true WHERE id = :appointmentId and patient = :patientId", nativeQuery = true)
    public void updatePatientAppointment(Integer appointmentId,Integer patientId);
}
