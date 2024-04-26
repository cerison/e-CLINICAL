package miu.cs.ads_datapersisitence.service;

import miu.cs.ads_datapersisitence.dto.response.PatientAppointmentDto;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Appointment;
import miu.cs.ads_datapersisitence.model.Patient;

import java.util.List;

public interface PatientService {
    public List<Patient> getAllPatient();
    public PatientAppointmentDto getPatient(Integer id);
    public Patient findPatient(Integer id);
    List<Patient> searchPatient(String query);
    public void addPatient(Patient patient);
    public void requestAppointment(Integer pid, Appointment appointment)  throws NotFoundException;
    public Patient updatePatient(Integer id, Patient patient)  throws NotFoundException;
    public void deletePatient(Integer id)  throws NotFoundException;
}
