package miu.cs.ads_datapersisitence.service;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.model.Appointment;
import miu.cs.ads_datapersisitence.model.Surgery;

import java.util.List;

public interface SurgeryService {
    public List<Surgery> getAllSurgery();
    public Surgery getSurgery(Integer id);
    List<Surgery> searchSurgery(String query);
    public void addSurgery(Surgery surgery);
    public Surgery updateSurgery(Integer id, Surgery surgery)  throws NotFoundException;
    public void addAppointment(Integer sid, Integer aid) throws NotFoundException;
    public void deleteSurgery(Integer id)  throws NotFoundException;
}