package project.pet.cadaster.personage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import project.pet.cadaster.personage.service.PersonageService;
import project.pet.cadaster.personage.transit.PersonageChangeDTO;
import project.pet.cadaster.personage.transit.PersonageCreateDTO;
import project.pet.cadaster.personage.transit.PersonageFilterDTO;
import project.pet.cadaster.personage.transit.PersonageMirrorResponseDTO;

@RestController
@RequestMapping("/personage")
public class PersonageController {

	@Autowired
	private PersonageService service;

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/index")
	public List<PersonageMirrorResponseDTO> listPersonage(PersonageFilterDTO filter) {
		return service.listPersonage(filter);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/find/{id}")
	public PersonageMirrorResponseDTO findPersonage(@PathVariable("id") Long personageId) {
		return service.find(personageId);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@CrossOrigin
	@PostMapping("/create")
	public PersonageMirrorResponseDTO createPersonage(@Valid PersonageCreateDTO dto) {
		return service.create(dto);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@PutMapping("/change")
	public PersonageMirrorResponseDTO changePersonage(@Valid PersonageChangeDTO dto) {
		return service.change(dto);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@CrossOrigin
	@DeleteMapping("/remove/{id}")
	public void removePersonage(@PathVariable("id") Long personageId) {
		service.remove(personageId);
	}
}
