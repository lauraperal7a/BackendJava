package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.entity.Address;
import com.example.clinicaOdontologica.repository.impl.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IEntityService<Address> {

    private IAddressRepository addressRepository;

    @Autowired
    public AddressService(IAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address update(Address address) {
        Address ad = addressRepository.getById(address.getId());
        ad.setStreet(address.getStreet());
        ad.setNumber(address.getNumber());
        ad.setLocation(address.getLocation());
        ad.setProvince(address.getProvince());
        addressRepository.save(ad);
        return ad;
    }

    @Override
    public void delete(Integer id) {
        Address ad = addressRepository.getById(id);
        addressRepository.delete(ad);
    }
}
