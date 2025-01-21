package com.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
