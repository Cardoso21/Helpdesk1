package com.cardoso.helpdesk.resources;

import com.cardoso.helpdesk.domain.Cliente;
import com.cardoso.helpdesk.domain.DTO.ClienteDTO;
import com.cardoso.helpdesk.domain.DTO.TecnicoDTO;
import com.cardoso.helpdesk.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	private ServletUriComponentsBuilder ServeletUriComponentsBuilder;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable Integer id){
		Cliente obj = this.service.findById(id);
		return ResponseEntity.ok().body(new ClienteDTO(obj));
	}

	@GetMapping
	public  ResponseEntity<List<ClienteDTO>> finfAll(){
		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity <ClienteDTO> create(@Valid @RequestBody ClienteDTO objDTO){
		Cliente newObj = service.create(objDTO);
		URI uri = ServeletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteDTO> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO objDTO ){
		Cliente obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new ClienteDTO(obj));

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
}
