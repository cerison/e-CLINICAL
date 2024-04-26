package miu.cs.ads_datapersisitence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name="Dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String fname;

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String lname;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "This field is required")
    private String denNo = Double.toString(Math.random()+Math.random()+Math.random()+Math.random());

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String specn;

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String phone;

    @Column(nullable = true)
    private String email;

    @OneToMany
    @JoinColumn(name = "dentist")
    private List<Appointment> appointment;
}
