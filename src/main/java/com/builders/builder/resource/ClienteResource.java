package com.builders.builder.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.builders.builder.domain.Cliente;
import com.builders.builder.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
 
	@Autowired
	private ClienteService servi;
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cliente>>findAll(){
		
		List<Cliente> list = servi.findAll();
		
		return ResponseEntity.ok().body(list);
		
		
		
	}
}
