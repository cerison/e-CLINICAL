package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.dto.response.DentistDto;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Appointment;
import miu.cs.ads_datapersisitence.model.Dentist;
import miu.cs.ads_datapersisitence.repository.AppointmentRepository;
import miu.cs.ads_datapersisitence.repository.DentistRepository;
import miu.cs.ads_datapersisitence.service.AppointmentService;
import miu.cs.ads_datapersisitence.service.DentistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {
    @Autowired
    DentistRepository dentistRepository;

    @Autowired
    AppointmentService appointmentService;

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<DentistDto> getAllDentist() {
        return dentistRepository.findAll()
                .stream()
                .map(dentist -> modelMapper.map(dentist, DentistDto.class))
                .map(dentist -> {
                   var apps = dentist.getAppointment();
                   if(apps != null){
                       apps = apps.stream()
                               .map(app->{
                                   app = appointmentService.getAppointment(app.getId());
                                   app.setDentist(null);
                                   return app;
                               })
                               .toList();
                       dentist.setAppointment(apps);
                   }
                   return dentist;
                })
                .toList();
    }

    @Override
    public Dentist getDentist(Integer id) {
        return dentistRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dentist> searchDentist(String query) {
        return dentistRepository.findDentistByFnameContainingOrLnameContainingOrSpecnContaining(query,query,query);
    }

    @Override
    public void addDentist(Dentist dentist) {
        dentistRepository.save(dentist);
    }

    @Override
    public Dentist updateDentist(Integer id, Dentist dentist) throws NotFoundException {
        Dentist dentist1 = getDentist(id);
        if(dentist1 == null){
            throw  new NotFoundException("Dentist is not available");
        }
        else{
            dentist.setId(dentist1.getId());
        }
        return dentistRepository.save(dentist);
    }

    @Override
    public void addAppointment(Integer did, Integer aid) throws NotFoundException{
        Dentist dentist = getDentist(did);
        Appointment appointment = appointmentRepository.findById(aid).orElse(null);
        if(dentist == null){
            throw  new NotFoundException("Dentist is not available");
        }else if(appointment == null){
            throw  new NotFoundException("Appointment is not available");
        } else{
            appointmentRepository.updateDentistAppointment(aid,did);
        }
    }

    @Override
    public void deleteDentist(Integer id) throws NotFoundException {
        Dentist dentist = getDentist(id);
        if(dentist == null){
            throw  new NotFoundException("Dentist is not available");
        }
        else{
            dentistRepository.deleteById(id);
        }
    }
}