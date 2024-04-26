package miu.cs.ads_datapersisitence.repository;

import miu.cs.ads_datapersisitence.model.Dentist;
import miu.cs.ads_datapersisitence.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
    public List<Dentist> findDentistByFnameContainingOrLnameContainingOrSpecnContaining(String fname, String lname, String specn);

}
