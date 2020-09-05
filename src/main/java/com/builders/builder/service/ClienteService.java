package com.builders.builder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builders.builder.Repository.ClienteReposity;
import com.builders.builder.domain.Cliente;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteReposity repo;

	public List<Cliente> findAll(){
		return repo.findAll();
		}
}
