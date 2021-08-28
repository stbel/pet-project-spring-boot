package project.pet.cadaster.institution.controller;

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

import project.pet.cadaster.institution.service.InstitutionService;
import project.pet.cadaster.institution.transit.InstitutionChangeDTO;
import project.pet.cadaster.institution.transit.InstitutionCreateDTO;
import project.pet.cadaster.institution.transit.InstitutionFilterDTO;
import project.pet.cadaster.institution.transit.InstitutionMirrorResponseDTO;

@RestController
@RequestMapping("/institution")
public class InstitutionController {

	@Autowired
	private InstitutionService service;

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/index")
	public List<InstitutionMirrorResponseDTO> listInstitution(InstitutionFilterDTO filter) {
		return service.listInstitution(filter);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/find/{id}")
	public InstitutionMirrorResponseDTO findInstitution(@PathVariable("id") Long institutionId) {
		return service.find(institutionId);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@CrossOrigin
	@PostMapping("/create")
	public InstitutionMirrorResponseDTO createInstitution(@Valid InstitutionCreateDTO dto) {
		return service.create(dto);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@PutMapping("/change")
	public InstitutionMirrorResponseDTO changeInstitution(@Valid InstitutionChangeDTO dto) {
		return service.change(dto);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@CrossOrigin
	@DeleteMapping("/remove/{id}")
	public void removeInstitution(@PathVariable("id") Long institutionId) {
		service.remove(institutionId);
	}
}
