package com.builders.builder.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<ClienteDto>findById(@PathVariable String id){
		Cliente clie =  servi.findById(id);
		
		return ResponseEntity.ok().body(new ClienteDto(clie));
		}
	@RequestMapping(value="/cpf/{cpf}",method=RequestMethod.GET)
	public ResponseEntity<ClienteDto>findByCpf(@PathVariable String cpf){
		Cliente clie =  servi.findByCpf(cpf);
		
		return ResponseEntity.ok().body(new ClienteDto(clie));
		}
	@RequestMapping(value="/nome/{nome}",method=RequestMethod.GET)
	public ResponseEntity<ClienteDto>findByNome(@PathVariable String nome){
		Cliente clie =  servi.findByNome(nome);
		
		return ResponseEntity.ok().body(new ClienteDto(clie));
		}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ClienteDto clienteDto){
		Cliente cli = servi.fromDto(clienteDto);
		cli= servi.insert(cli);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cli.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody ClienteDto clienteDto,@PathVariable String id){
		Cliente cli = servi.fromDto(clienteDto);
		cli.setId(id);
		cli= servi.update(cli);
		return ResponseEntity.noContent().build();
		}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void>delete(@PathVariable String id){
		  servi.delete(id);
		
		return ResponseEntity.noContent().build();
		}
}
