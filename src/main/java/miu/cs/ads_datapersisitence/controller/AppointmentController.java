package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.dto.response.AppointmentDto;
import miu.cs.ads_datapersisitence.model.Appointment;
import miu.cs.ads_datapersisitence.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ads/api/v1/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @GetMapping()
    public List<AppointmentDto> getAllAppointment(){
        return appointmentService.getAllAppointment();
    }

    @PostMapping()
    public void addAppointment(@RequestBody Appointment appointment){
        appointmentService.addAppointment(appointment);
    }

    @GetMapping("/{id}")
    public AppointmentDto getAllAppointment(@PathVariable Integer id){
        return appointmentService.getAppointment(id);
    }
}
