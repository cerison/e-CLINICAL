package miu.cs.ads_datapersisitence.repository;

import miu.cs.ads_datapersisitence.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


    public List<Patient> findPatientsByFnameContainingOrLnameContainingOrAddress_StreetContainingOrAddress_CityContainingOrAddress_StateContaining(String fname,String lname,String street,String city,String state);

}