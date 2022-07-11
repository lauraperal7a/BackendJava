package com.example.clinicaOdontologica.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name= "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    @SequenceGenerator(name= "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    private String name;
    private String lastName;
    private String dni;
    private Date entryDate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    public Patient() {
    }

    public Patient(String name, String lastName, String dni, Date entryDate, Address address) {
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.entryDate = entryDate;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getEntryDate() {
        return entryDate;
    }
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", entryDate=" + entryDate +
                ", address=" + address +
                '}';
    }
}
