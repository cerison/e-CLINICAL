package miu.cs.ads_datapersisitence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String street;

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String city;

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String state;

    @Column(nullable = false)
    @NotNull(message = "This field is required")
    private Integer zipcode;
}