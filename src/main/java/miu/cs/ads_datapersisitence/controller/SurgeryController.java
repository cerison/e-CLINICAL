package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Appointment;
import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.model.Surgery;
import miu.cs.ads_datapersisitence.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ads/api/v1/surgery")
public class SurgeryController {
    @Autowired
    SurgeryService surgeryService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Surgery> getAllSurgery() {
        return surgeryService.getAllSurgery();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Surgery getSurgery(@PathVariable(value = "id") Integer id){
        return surgeryService.getSurgery(id);
    }

    @GetMapping("/search/{query}")
    @ResponseStatus(HttpStatus.OK)
    public List<Surgery> searchSurgery(@PathVariable String query) {
        return surgeryService.searchSurgery(query);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addPatient(@RequestBody Surgery surgery) {
        surgeryService.addSurgery(surgery);
    }

    @PostMapping("/appointment/{sid}/{aid}")
    public void addAppointment(@PathVariable  Integer sid, @PathVariable  Integer aid)   throws NotFoundException{
        surgeryService.addAppointment(sid, aid);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Surgery updateSurgery(@PathVariable(value = "id") Integer id, @RequestBody Surgery surgery)  throws NotFoundException {
        return surgeryService.updateSurgery(id,surgery);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSurgery(@PathVariable(value = "id") Integer id)  throws NotFoundException {
        surgeryService.deleteSurgery(id);
    }
}
