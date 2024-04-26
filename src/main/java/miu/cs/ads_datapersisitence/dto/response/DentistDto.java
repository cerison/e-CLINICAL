package miu.cs.ads_datapersisitence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistDto {
        Integer id;
        String fname;
        String lname;
        String phone;
        String email;
        String denNo;
        String specn;
        List<AppointmentDto> appointment;
}
