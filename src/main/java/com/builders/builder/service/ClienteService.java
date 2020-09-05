package com.builders.builder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builders.builder.Repository.ClienteReposity;
import com.builders.builder.domain.Cliente;
import com.builders.builder.service.exception.ObjectNotFoundException;

import com.sun.jdi.ObjectCollectedException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteReposity repo;

	public List<Cliente> findAll(){
		return repo.findAll();
		}
	
	public Cliente findByCpf(String cpf) {
		
		Optional<Cliente> cliente = repo.findByCpf(cpf);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
public Cliente findByNome(String nome) {
		
		Optional<Cliente> cliente = repo.findByNome(nome);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
