package miu.cs.ads_datapersisitence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Surgery")
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String name;

    @OneToOne
    private Address address;

    @OneToMany
    @JoinColumn(name = "surgery")
    private List<Appointment> appointment = new ArrayList<>();

}