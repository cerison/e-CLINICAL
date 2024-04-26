package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.dto.response.AddressDto;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Address;
import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ads/api/v1/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping()
    public List<AddressDto> getAddress() {
        return addressService.getAddress();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Address getAddress(@PathVariable(value = "id") Integer id){
        return addressService.getAddress(id);
    }

    @GetMapping("/search/{query}")
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDto> searchAddress(@PathVariable String query) {
        return addressService.searchAddress(query);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@RequestBody Address address) {
        addressService.addAddress(address);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Address updateAddress(@PathVariable(value = "id") Integer id, @RequestBody Address address)  throws NotFoundException {
        return addressService.updateAddress(id,address);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable(value = "id") Integer id)  throws NotFoundException {
        addressService.deleteAddress(id);
    }
}
