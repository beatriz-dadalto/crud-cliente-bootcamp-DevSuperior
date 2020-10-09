package com.biacoelho.crudcliente.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biacoelho.crudcliente.dto.CustomerDTO;
import com.biacoelho.crudcliente.entities.Customer;
import com.biacoelho.crudcliente.repositories.CustomerRepository;
import com.biacoelho.crudcliente.services.exceptions.DatabaseException;
import com.biacoelho.crudcliente.services.exceptions.ResourceNotFoundException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
	@Transactional(readOnly = true)
	public Page<CustomerDTO> findAllPaged(PageRequest pageRequest) {
		Page<Customer> list = repository.findAll(pageRequest);
		return list.map(x -> new CustomerDTO(x));
	}

	@Transactional(readOnly = true)
	public CustomerDTO findById(Long id) {
		Optional<Customer> obj = repository.findById(id);
		Customer entity = obj.orElseThrow(() -> new ResourceNotFoundException("Error: Entity not found ;("));
		return new CustomerDTO(entity);
	}
	
	@Transactional
	public CustomerDTO insert(CustomerDTO dto) {
		Customer entity = new Customer();
		
		entity.setName(dto.getName());
		entity.setCpf(dto.getCpf());
		entity.setIncome(dto.getIncome());
		entity.setBirthDate(dto.getBirthDate());
		entity.setChildren(dto.getChildren());
		
		entity = repository.save(entity);
		
		return new CustomerDTO(entity);
	}

	@Transactional
	public CustomerDTO update(Long id, CustomerDTO dto) {
		try {
			Customer entity = repository.getOne(id);
			
			entity.setName(dto.getName());
			entity.setCpf(dto.getCpf());
			entity.setIncome(dto.getIncome());
			entity.setBirthDate(dto.getBirthDate());
			entity.setChildren(dto.getChildren());
			
			entity = repository.save(entity);
			
			return new CustomerDTO(entity);
			
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("ID " + id + " not found :(");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("ID " + id + " not foud :(");
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
		
		
	}
}
