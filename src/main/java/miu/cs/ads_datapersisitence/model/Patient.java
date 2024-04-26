package miu.cs.ads_datapersisitence.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Patients")
public class Patient {
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
    private String patNo = Double.toString(Math.random()+Math.random()+Math.random()+Math.random());

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String phone;

    @Column(nullable = true)
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "This field is required")
    private String dob;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient")
    private List<Appointment> appointment;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}