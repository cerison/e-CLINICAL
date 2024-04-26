package miu.cs.ads_datapersisitence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.cs.ads_datapersisitence.model.Address;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAppointmentDto {
    Integer id;
    String fname;
    String lname;
    String phone;
    String email;
    String patNo;
    String dob;
    Address address;
    List<AppointmentDto> appointment;
}
