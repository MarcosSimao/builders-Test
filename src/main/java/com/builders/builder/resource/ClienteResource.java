package com.builders.builder.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.builders.builder.domain.Cliente;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>>findAll(){
		Cliente marcos = new Cliente(1L,"MArcos","09898877","14019199");
		Cliente goku = new Cliente(2L,"goku","09218987","12012990");
		List<Cliente> list = new ArrayList();
		list.addAll(Arrays.asList(marcos,goku));
		return ResponseEntity.ok().body(list);
		
		
		
	}
}
