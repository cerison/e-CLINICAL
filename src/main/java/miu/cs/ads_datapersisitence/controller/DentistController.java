package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.dto.response.DentistDto;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Appointment;
import miu.cs.ads_datapersisitence.model.Dentist;
import miu.cs.ads_datapersisitence.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ads/api/v1/dentist")
public class DentistController {
    @Autowired
    DentistService dentistService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<DentistDto> getAllDentist() {
        return dentistService.getAllDentist();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dentist getDentist(@PathVariable(value = "id") Integer id){
        return dentistService.getDentist(id);
    }

    @GetMapping("/search/{query}")
    @ResponseStatus(HttpStatus.OK)
    public List<Dentist> searchDentist(@PathVariable String query) {
        return dentistService.searchDentist(query);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addDentist(@RequestBody Dentist dentist) {
        dentistService.addDentist(dentist);
    }

    @PostMapping("/appointment/{pid}/{aid}")
    public void addAppointment(@PathVariable  Integer pid, @PathVariable  Integer aid)   throws NotFoundException{
        dentistService.addAppointment(pid, aid);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Dentist updateDentist(@PathVariable(value = "id") Integer id, @RequestBody Dentist dentist)  throws NotFoundException {
        return dentistService.updateDentist(id,dentist);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDentist(@PathVariable(value = "id") Integer id)  throws NotFoundException {
        dentistService.deleteDentist(id);
    }
}