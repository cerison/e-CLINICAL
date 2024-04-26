package miu.cs.ads_datapersisitence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleAddressDto {
    private Integer id;
    private String street;
    private String city;
    private String state;
    private Integer zip;
}
