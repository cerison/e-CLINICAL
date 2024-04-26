package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.dto.response.AppointmentDto;
import miu.cs.ads_datapersisitence.dto.response.SimpleDentistDto;
import miu.cs.ads_datapersisitence.dto.response.SimplePatientAddressDto;
import miu.cs.ads_datapersisitence.dto.response.SimpleSurgeryDto;
import miu.cs.ads_datapersisitence.model.Appointment;
import miu.cs.ads_datapersisitence.model.Dentist;
import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.model.Surgery;
import miu.cs.ads_datapersisitence.repository.AppointmentRepository;
import miu.cs.ads_datapersisitence.repository.DentistRepository;
import miu.cs.ads_datapersisitence.repository.PatientRepository;
import miu.cs.ads_datapersisitence.repository.SurgeryRepository;
import miu.cs.ads_datapersisitence.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    SurgeryRepository surgeryRepository;

    @Autowired
    DentistRepository dentistRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<AppointmentDto> getAllAppointment() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointment -> {

                    AppointmentDto appointmentDto = modelMapper.map(appointment, AppointmentDto.class);

                    List<Patient> patient = patientRepository.findAll();
                    if(patient.size() > 0){
                        patient = patient.stream()
                                .filter(patient1 -> {
                                    List<Appointment> appointments = patient1.getAppointment();
                                    if(appointments.size() > 0){
                                        appointments = appointments.stream()
                                                .filter(appointment1 -> appointment1.getId() == appointment.getId())
                                                .toList();
                                    }
                                    return (appointments.size() > 0) ? true : false;
                                })
                                .toList();

                        if(patient.size() > 0){ appointmentDto.setPatient(modelMapper.map(patient.get(0), SimplePatientAddressDto.class));}
                    }

                    List<Surgery> surgeries = surgeryRepository.findAll();
                    if(surgeries.size() > 0){
                        surgeries = surgeries.stream()
                                .filter(surgery -> {
                                    List<Appointment> appointments = surgery.getAppointment();
                                    if(appointments.size() > 0){
                                        appointments = appointments.stream()
                                                .filter(appointment1 -> appointment1.getId() == appointment.getId())
                                                .toList();
                                    }
                                    return (appointments.size() > 0) ? true : false;
                                })
                                .toList();

                        if(surgeries.size() > 0){ appointmentDto.setSurgery(modelMapper.map(surgeries.get(0), SimpleSurgeryDto.class));}
                    }

                    List<Dentist> dentist = dentistRepository.findAll();
                    if(dentist.size() > 0){
                        dentist = dentist.stream()
                                .filter(dentist1 -> {
                                    List<Appointment> appointments = dentist1.getAppointment();
                                    if(appointments.size() > 0){
                                        appointments = appointments.stream()
                                                .filter(appointment1 -> appointment1.getId() == appointment.getId())
                                                .toList();
                                    }
                                    return (appointments.size() > 0) ? true : false;
                                })
                                .toList();

                        if(dentist.size() > 0){ appointmentDto.setDentist(modelMapper.map(dentist.get(0), SimpleDentistDto.class));}
                    }

                    return appointmentDto;
                })
                .toList();
    }

    @Override
    public AppointmentDto getAppointment(Integer id) {
        return appointmentRepository.findById(id)
                .map(appointment -> {

                    AppointmentDto appointmentDto = modelMapper.map(appointment, AppointmentDto.class);

                    List<Patient> patient = patientRepository.findAll();
                    if(patient.size() > 0){
                        patient = patient.stream()
                                .filter(patient1 -> {
                                    List<Appointment> appointments = patient1.getAppointment();
                                    if(appointments.size() > 0){
                                        appointments = appointments.stream()
                                                .filter(appointment1 -> appointment1.getId() == appointment.getId())
                                                .toList();
                                    }
                                    return (appointments.size() > 0) ? true : false;
                                })
                                .toList();

                        if(patient.size() > 0){ appointmentDto.setPatient(modelMapper.map(patient.get(0), SimplePatientAddressDto.class));}
                    }

                    List<Surgery> surgeries = surgeryRepository.findAll();
                    if(surgeries.size() > 0){
                        surgeries = surgeries.stream()
                                .filter(surgery -> {
                                    List<Appointment> appointments = surgery.getAppointment();
                                    if(appointments.size() > 0){
                                        appointments = appointments.stream()
                                                .filter(appointment1 -> appointment1.getId() == appointment.getId())
                                                .toList();
                                    }
                                    return (appointments.size() > 0) ? true : false;
                                })
                                .toList();

                        if(surgeries.size() > 0){ appointmentDto.setSurgery(modelMapper.map(surgeries.get(0), SimpleSurgeryDto.class));}
                    }

                    List<Dentist> dentist = dentistRepository.findAll();
                    if(dentist.size() > 0){
                        dentist = dentist.stream()
                                .filter(dentist1 -> {
                                    List<Appointment> appointments = dentist1.getAppointment();
                                    if(appointments.size() > 0){
                                        appointments = appointments.stream()
                                                .filter(appointment1 -> appointment1.getId() == appointment.getId())
                                                .toList();
                                    }
                                    return (appointments.size() > 0) ? true : false;
                                })
                                .toList();

                        if(dentist.size() > 0){ appointmentDto.setDentist(modelMapper.map(dentist.get(0), SimpleDentistDto.class));}
                    }

                    return appointmentDto;
                })
                .orElse(null);
    }

    @Override
    public void addAppointment(Appointment appointment){
        appointmentRepository.save(appointment);
    }
}