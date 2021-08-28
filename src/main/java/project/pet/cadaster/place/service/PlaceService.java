package project.pet.cadaster.place.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.pet.cadaster.place.model.Place;
import project.pet.cadaster.place.model.PlaceRepository;
import project.pet.cadaster.place.transit.PlaceChangeDTO;
import project.pet.cadaster.place.transit.PlaceCreateDTO;
import project.pet.cadaster.place.transit.PlaceFilterDTO;
import project.pet.cadaster.place.transit.PlaceMirrorMapper;
import project.pet.cadaster.place.transit.PlaceMirrorResponseDTO;

@Service
public class PlaceService {

	@Autowired
	private PlaceRepository repository;

	@Autowired
	private PlaceMirrorMapper mapper;

	public List<PlaceMirrorResponseDTO> listPlace(PlaceFilterDTO filter) {
		
		List<Place> list = repository.findAll();

		List<PlaceMirrorResponseDTO> dtoList = mapper.toRepresentation(list);

		return dtoList;
	}

	public PlaceMirrorResponseDTO find(Long personageId) {

		Optional<Place> optional = repository.findById(personageId);

		if (optional.isEmpty()) {
			return null;
		}

		return mapper.toRepresentation(optional.get());
	}

	public PlaceMirrorResponseDTO create(@Valid PlaceCreateDTO dto) {

		return null;
	}

	public PlaceMirrorResponseDTO change(@Valid PlaceChangeDTO dto) {

		return null;
	}

	public void remove(Long personageId) {
		
		repository.deleteById(personageId);
	}
}
