package com.builders.builder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builders.builder.Repository.ClienteReposity;
import com.builders.builder.domain.Cliente;
import com.builders.builder.dto.ClienteDto;
import com.builders.builder.service.exception.ObjectNotFoundException;

import com.sun.jdi.ObjectCollectedException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteReposity repo;

	public List<Cliente> findAll(){
		return repo.findAll();
		}
	
	public Cliente findById(String id) {
		Optional<Cliente> cliente = repo.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	public Cliente findByCpf(String cpf) {
		
		Optional<Cliente> cliente = repo.findByCpf(cpf);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
public Cliente findByNome(String nome) {

		
		Optional<Cliente> cliente = repo.findByNome(nome);
		
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}


public Cliente insert(Cliente cliente) {
	
if(verificarCpf(cliente)) {
		throw	new ObjectNotFoundException("cpf não encontrado");
	}
		
	return repo.insert(cliente);
	
}
public boolean verificarCpf(Cliente cliente) {

	List<Cliente> newClie = findAll();
	for(Cliente c : newClie) {
		if(c.getCpf().equals(cliente.getCpf())) {
			return true;
			}
			}
	return false;	
		}


public void delete(String id) {

	findById(id);
	repo.deleteById(id);	
	
}



public Cliente update(Cliente cliente) {
	Cliente newClie = findById(cliente.getId());
	
	updateNew(newClie,cliente);
	return repo.save(newClie);
	
	
}

public void updateNew(Cliente newClie,Cliente cliente) {
	newClie.setNome(cliente.getNome());
	newClie.setCpf(cliente.getCpf());
	newClie.setDataNascimento(cliente.getDataNascimento());
}
public Cliente fromDto(ClienteDto clienteDto) {
	return new Cliente(clienteDto.getId(),clienteDto.getNome(),clienteDto.getCpf(),clienteDto.getDataNascimento());
	
}
}
