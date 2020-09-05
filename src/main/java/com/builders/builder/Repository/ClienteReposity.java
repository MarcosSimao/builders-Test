package com.builders.builder.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.builders.builder.domain.Cliente;


@Repository
public interface ClienteReposity  extends MongoRepository<Cliente, String>{

	 Optional<Cliente> findByCpf(String cpf);
	 Optional<Cliente> findByNome(String nome);

	

}
