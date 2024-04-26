package miu.cs.ads_datapersisitence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleDentistDto {
    Integer id;
    String fname;
    String lname;
    String phone;
    String email;
    String denNo;
    String specn;
}