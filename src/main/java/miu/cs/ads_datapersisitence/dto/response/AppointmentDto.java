package miu.cs.ads_datapersisitence.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    private Integer id;
    private LocalDate date;
    private Time time;
    private Boolean status;
    SimplePatientAddressDto patient;
    SimpleSurgeryDto surgery;
    SimpleDentistDto dentist;
}
