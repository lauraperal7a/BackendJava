package com.example.clinicaOdontologica.entity;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    @SequenceGenerator(name= "address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @Column(name= "id")
    private Integer id;
    private String street;
    private String number;
    private String location;
    private String province;

    public Address() {
    }

    public Address(String street, String number, String location, String province) {
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", location='" + location + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
