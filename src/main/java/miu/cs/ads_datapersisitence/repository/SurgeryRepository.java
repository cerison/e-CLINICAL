package miu.cs.ads_datapersisitence.repository;

import miu.cs.ads_datapersisitence.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurgeryRepository  extends JpaRepository<Surgery, Integer> {
    public List<Surgery> findByNameContaining(String name);

}
