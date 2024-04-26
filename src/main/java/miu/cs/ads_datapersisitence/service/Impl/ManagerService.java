package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.repository.AppointmentRepository;
import miu.cs.ads_datapersisitence.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ManagerService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentRepository appointmentRepository;
    public void approveRequest(Integer patientId, Integer appointmentId) throws NotFoundException {
        var patient = patientRepository.findById(patientId).orElse(null);
        var appt = appointmentRepository.findById(appointmentId).orElse(null);
        if(patient == null){
            throw new NotFoundException("Patient is not available");
        } else if (appt == null) {
            throw new NotFoundException("Appointment is not available");
        }else {
            appointmentRepository.updatePatientAppointment(appointmentId,patientId);
        }
    }
}
