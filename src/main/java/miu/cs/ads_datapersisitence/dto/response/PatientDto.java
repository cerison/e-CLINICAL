package miu.cs.ads_datapersisitence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    Integer id;
    String fname;
    String lname;
    String phone;
    String email;
    String patNo;
    String dob;
}
