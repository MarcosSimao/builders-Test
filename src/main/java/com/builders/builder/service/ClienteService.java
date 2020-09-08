package com.builders.builder.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.builders.builder.Repository.ClienteReposity;
import com.builders.builder.domain.Cliente;
import com.builders.builder.dto.ClienteDto;
import com.builders.builder.service.exception.ObjectNotFoundException;
import com.builders.builder.service.exception.ObjectUnauthorizedException;
import com.sun.jdi.ObjectCollectedException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteReposity repo;

	public Page<Cliente> findAllP(Pageable pagina){
		Page<Cliente> pagi = repo.findAll(pagina);
		return pagi;
		}
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
	if(checkCpf(cliente)) {
		throw	new ObjectUnauthorizedException("cpf ja existente !!!");
	}
		
	return repo.insert(cliente);
	
}
public boolean checkCpf(Cliente cliente) {

	List<Cliente> existingCustomer = findAll();
	for(Cliente c : existingCustomer) {
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
	if(updatecheckCpf(cliente)) {
		throw	new ObjectUnauthorizedException("cpf ja existente !!!");
	}
	return repo.save(newClie);
	
}
public boolean updatecheckCpf(Cliente cliente) {
	List<Cliente> existingCustomer = findAll();
	for(Cliente c : existingCustomer) {
		if(c.getCpf().equals(cliente.getCpf())) {
			if(!c.getId().equals(cliente.getId()))
			return true;
			}else if(c.getCpf().equals(cliente.getCpf())) {
				if(c.getId().equals(cliente.getId())) {
					
					return false;
					}
				}
		
		}
	return false;
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
