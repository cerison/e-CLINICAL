package miu.cs.ads_datapersisitence.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimplePatientDto {
    String fname;
    String lname;
    String phone;
    String email;
    String dob;
    Integer addressId;
}
