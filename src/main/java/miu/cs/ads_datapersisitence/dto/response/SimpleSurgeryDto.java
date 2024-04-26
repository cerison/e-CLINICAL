package miu.cs.ads_datapersisitence.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.cs.ads_datapersisitence.model.Address;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleSurgeryDto {
        private Integer id;
        private String name;
        private Address address;
}
