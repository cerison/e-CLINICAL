package miu.cs.ads_datapersisitence.service.Impl;

import miu.cs.ads_datapersisitence.dto.response.AddressDto;
import miu.cs.ads_datapersisitence.dto.response.PatientDto;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Address;
import miu.cs.ads_datapersisitence.repository.AddressRepository;
import miu.cs.ads_datapersisitence.repository.PatientRepository;
import miu.cs.ads_datapersisitence.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<AddressDto> getAddress() {
        return addressRepository.findAll()
                .stream()
                .map(address1 -> modelMapper.map(address1,AddressDto.class))
                .map(address -> {

                    var patient = patientRepository.findAll()
                            .stream()
                            .filter(patient1 -> patient1.getAddress().getId() == address.getId())
                            .toList();

                    if(patient.size() > 0 ){
                        if(patient.get(0) != null){
                            address.setPatient(modelMapper.map(patient.get(0), PatientDto.class));
                        }
                    }
                    return address;
                })
                .sorted(Comparator.comparing(AddressDto::getCity))
                .toList();
    }

    @Override
    public Address getAddress(Integer id) {
        return addressRepository.findById(id).orElse(null);
    }

    @Override
    public List<AddressDto> searchAddress(String query) {
        return addressRepository.findAddressesByStreetContainingOrCityContainingOrStateContaining(query,query,query)
                .stream()
                .map(address1 -> modelMapper.map(address1,AddressDto.class))
                .map(address -> {

                    var patient = patientRepository.findAll()
                            .stream()
                            .filter(patient1 -> patient1.getAddress().getId() == address.getId())
                            .toList();

                    if(patient.size() > 0 ){
                        if(patient.get(0) != null){
                            address.setPatient(modelMapper.map(patient.get(0), PatientDto.class));
                        }
                    }
                    return address;
                })
                .sorted(Comparator.comparing(AddressDto::getCity))
                .toList();
    }

    @Override
    public void addAddress(Address address) {
        addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Integer id, Address address) throws NotFoundException {
        Address address1 = getAddress(id);
        if(address1 == null){
            throw  new NotFoundException("Address is not available");
        }
        else{
            address.setId(address1.getId());
        }
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Integer id) throws NotFoundException {
        Address address1 = getAddress(id);
        if(address1 == null){
            throw  new NotFoundException("Address is not available");
        }
        else{
            addressRepository.deleteById(id);
        }
    }
}