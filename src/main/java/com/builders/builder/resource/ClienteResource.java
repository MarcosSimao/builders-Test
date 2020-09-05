package com.builders.builder.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.builders.builder.domain.Cliente;
import com.builders.builder.dto.ClienteDto;
import com.builders.builder.service.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
 
	@Autowired
	private ClienteService servi;
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDto>>findAll(){
		
		List<Cliente> list = servi.findAll();
		List<ClienteDto> listDto = list.stream().map(x -> new ClienteDto(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
		
		
	}
}
