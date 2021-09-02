package com.cardoso.helpdesk.resources;

import com.cardoso.helpdesk.domain.DTO.TecnicoDTO;
import com.cardoso.helpdesk.services.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.cardoso.helpdesk.domain.Tecnico;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoResource {

	@Autowired
	private TecnicoService service;

	private ServletUriComponentsBuilder ServeletUriComponentsBuilder;

	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		Tecnico obj = this.service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	@PreAuthorize("hasAnyRole('ADMIM')")
	@GetMapping
	public  ResponseEntity<List<TecnicoDTO>> finfAll(){
		List<Tecnico> list = service.findAll();
		List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	@PreAuthorize("hasAnyRole('ADMIM')")
	@PostMapping
	public ResponseEntity <TecnicoDTO> create(@Valid @RequestBody TecnicoDTO objDTO){
		Tecnico newObj = service.create(objDTO);
		URI uri = ServeletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PreAuthorize("hasAnyRole('ADMIM')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> update(@PathVariable Integer id, @Valid @RequestBody TecnicoDTO objDTO ){
		Tecnico obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));

	}

	@PreAuthorize("hasAnyRole('ADMIM')")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> delete (@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
}
