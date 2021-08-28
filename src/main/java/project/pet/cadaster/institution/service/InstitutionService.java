package project.pet.cadaster.institution.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.pet.cadaster.institution.model.Institution;
import project.pet.cadaster.institution.model.InstitutionRepository;
import project.pet.cadaster.institution.transit.InstitutionChangeDTO;
import project.pet.cadaster.institution.transit.InstitutionCreateDTO;
import project.pet.cadaster.institution.transit.InstitutionFilterDTO;
import project.pet.cadaster.institution.transit.InstitutionMirrorMapper;
import project.pet.cadaster.institution.transit.InstitutionMirrorResponseDTO;

@Service
public class InstitutionService {

	@Autowired
	private InstitutionRepository repository;

	@Autowired
	private InstitutionMirrorMapper mapper;

	public List<InstitutionMirrorResponseDTO> listInstitution(InstitutionFilterDTO filter) {
		
		List<Institution> list = repository.findAll();

		List<InstitutionMirrorResponseDTO> dtoList = mapper.toRepresentation(list);

		return dtoList;
	}

	public InstitutionMirrorResponseDTO find(Long personageId) {

		Optional<Institution> optional = repository.findById(personageId);

		if (optional.isEmpty()) {
			return null;
		}

		return mapper.toRepresentation(optional.get());
	}

	public InstitutionMirrorResponseDTO create(@Valid InstitutionCreateDTO dto) {

		return null;
	}

	public InstitutionMirrorResponseDTO change(@Valid InstitutionChangeDTO dto) {

		return null;
	}

	public void remove(Long personageId) {
		
		repository.deleteById(personageId);
	}
}
