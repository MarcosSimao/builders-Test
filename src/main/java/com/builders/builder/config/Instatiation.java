package com.builders.builder.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.builders.builder.Repository.ClienteReposity;
import com.builders.builder.domain.Cliente;
@Configuration
public class Instatiation  implements CommandLineRunner{
    
	@Autowired
	private ClienteReposity clie;
	
	@Override
	public void run(String... args) throws Exception {
		
		clie.deleteAll();
		
		Cliente marcos = new Cliente(null,"Marcos alecrim","123.345.093.23","12/02/1993");
		Cliente lucas = new Cliente(null,"Lucas almeida","234.123.093.33","01/12/1999");
		Cliente leticia = new Cliente(null,"Leticia afrodite","983.345.456.11","23/11/2001");
		Cliente januario = new Cliente(null,"Januario ferreira","345.784.093.23","22/10/1990");
		
		clie.saveAll(Arrays.asList(marcos, lucas, leticia,januario));
	}

}
