package project.pet.cadaster.personage.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.pet.cadaster.personage.model.Personage;
import project.pet.cadaster.personage.model.PersonageRepository;
import project.pet.cadaster.personage.transit.PersonageChangeDTO;
import project.pet.cadaster.personage.transit.PersonageCreateDTO;
import project.pet.cadaster.personage.transit.PersonageFilterDTO;
import project.pet.cadaster.personage.transit.PersonageMirrorMapper;
import project.pet.cadaster.personage.transit.PersonageMirrorResponseDTO;

@Service
public class PersonageService {

	@Autowired
	private PersonageRepository repository;

	@Autowired
	private PersonageMirrorMapper mapper;

	public List<PersonageMirrorResponseDTO> listPersonage(PersonageFilterDTO filter) {
		
		List<Personage> list = repository.findAll();

		List<PersonageMirrorResponseDTO> dtoList = mapper.toRepresentation(list);

		return dtoList;
	}

	public PersonageMirrorResponseDTO find(Long personageId) {

		Optional<Personage> optional = repository.findById(personageId);

		if (optional.isEmpty()) {
			return null;
		}

		return mapper.toRepresentation(optional.get());
	}

	public PersonageMirrorResponseDTO create(@Valid PersonageCreateDTO dto) {

		return null;
	}

	public PersonageMirrorResponseDTO change(@Valid PersonageChangeDTO dto) {

		return null;
	}

	public void remove(Long personageId) {
		
		repository.deleteById(personageId);
	}

}
