package miu.cs.ads_datapersisitence.service.Impl;
import miu.cs.ads_datapersisitence.dto.response.PatientAppointmentDto;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Appointment;
import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.repository.AppointmentRepository;
import miu.cs.ads_datapersisitence.repository.PatientRepository;
import miu.cs.ads_datapersisitence.service.AppointmentService;
import miu.cs.ads_datapersisitence.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<Patient> getAllPatient() {
        var patient = patientRepository.findAll();
        return (patient.size() == 0) ? patient : patient.stream().sorted(Comparator.comparing(Patient::getLname)).toList();
    }

    @Override
    public PatientAppointmentDto getPatient(Integer id){
        return patientRepository.findById(id)
                .map(patient -> modelMapper.map(patient, PatientAppointmentDto.class))
                .map(patientAppointmentDto -> {
                    var apps = patientAppointmentDto.getAppointment();
                    if(apps != null){
                        apps = apps.stream()
                                .map(app->{
                                    app = appointmentService.getAppointment(app.getId());
                                    app.setPatient(null);
                                    return app;
                                })
                                .toList();
                        patientAppointmentDto.setAppointment(apps);
                    }
                    return patientAppointmentDto;
                })
                .orElse(null);
    }

    @Override
    public Patient findPatient(Integer id){
        Patient patient = patientRepository.findById(id).orElse(null);
        return patient;
    }

    @Override
    public List<Patient> searchPatient(String query) {
        var patient = patientRepository.findPatientsByFnameContainingOrLnameContainingOrAddress_StreetContainingOrAddress_CityContainingOrAddress_StateContaining(query,query,query,query,query);;
        return (patient.size() == 0) ? patient : patient.stream().sorted(Comparator.comparing(Patient::getLname)).toList();
    }

    @Override
    public void addPatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public void requestAppointment(Integer pid, Appointment appointment) throws NotFoundException{
        Patient patient = findPatient(pid);
        if(patient == null){
            throw  new NotFoundException("Patient is not available");
        } else{
            List<Appointment> appointments = patient.getAppointment();
            if(appointments.size() == 0){
                appointments = new ArrayList<>();
            }
            appointments.add(appointment);
            patient.setAppointment(appointments);
            patientRepository.save(patient);
        }
    }

    @Override
    public Patient updatePatient(Integer id, Patient patient) throws NotFoundException{
        Patient patient1 = findPatient(id);
        if(patient1 == null){
            throw  new NotFoundException("Patient is not available");
        }
        else{
            patient.setId(patient1.getId());
            patient.getAddress().setId(patient1.getAddress().getId());
            return patientRepository.save(patient);
        }
    }

    @Override
    public void deletePatient(Integer id)  throws NotFoundException{
        Patient patient1 = findPatient(id);

        if(patient1 == null){
            throw  new NotFoundException("Patient is not available");
        }
        else{
            patientRepository.deleteById(id);
        }
    }
}