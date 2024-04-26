package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.dto.request.SimplePatientDto;
import miu.cs.ads_datapersisitence.dto.response.PatientAppointmentDto;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Appointment;
import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ads/api/v1/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PatientAppointmentDto getPatient(@PathVariable(value = "id") Integer id){
        return patientService.getPatient(id);
    }

    @GetMapping("/search/{query}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> searchPatient(@PathVariable String query) {
        return patientService.searchPatient(query);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @PostMapping("/appointment/{pid}")
    public void requestAppointment(@PathVariable  Integer pid, @RequestBody Appointment appointment)   throws NotFoundException{
        patientService.requestAppointment(pid, appointment);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient updatePatient(@PathVariable(value = "id") Integer id, @RequestBody Patient patient)  throws NotFoundException {
        return patientService.updatePatient(id,patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatient(@PathVariable(value = "id") Integer id)  throws NotFoundException {
        patientService.deletePatient(id);
    }
}