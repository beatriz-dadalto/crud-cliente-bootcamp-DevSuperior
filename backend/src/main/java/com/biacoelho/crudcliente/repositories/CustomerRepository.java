package com.biacoelho.crudcliente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biacoelho.crudcliente.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
