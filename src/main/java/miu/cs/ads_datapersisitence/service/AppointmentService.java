package miu.cs.ads_datapersisitence.service;

import miu.cs.ads_datapersisitence.dto.response.AppointmentDto;
import miu.cs.ads_datapersisitence.model.Appointment;

import java.util.List;

public interface AppointmentService {

    public List<AppointmentDto> getAllAppointment();
    public AppointmentDto getAppointment(Integer id);
    public void addAppointment(Appointment appointment);
}
