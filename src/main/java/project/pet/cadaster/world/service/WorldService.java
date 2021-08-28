package project.pet.cadaster.world.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.pet.cadaster.world.model.World;
import project.pet.cadaster.world.model.WorldRepository;
import project.pet.cadaster.world.transit.WorldChangeDTO;
import project.pet.cadaster.world.transit.WorldCreateDTO;
import project.pet.cadaster.world.transit.WorldFilterDTO;
import project.pet.cadaster.world.transit.WorldMirrorMapper;
import project.pet.cadaster.world.transit.WorldMirrorResponseDTO;

@Service
public class WorldService {

	@Autowired
	private WorldRepository repository;

	@Autowired
	private WorldMirrorMapper mapper;

	public List<WorldMirrorResponseDTO> listWorld(WorldFilterDTO filter) {
		
		List<World> list = repository.findAll();

		List<WorldMirrorResponseDTO> dtoList = mapper.toRepresentation(list);

		return dtoList;
	}

	public WorldMirrorResponseDTO find(Long worldId) {

		Optional<World> optional = repository.findById(worldId);

		if (optional.isEmpty()) {
			return null;
		}

		return mapper.toRepresentation(optional.get());
	}

	public WorldMirrorResponseDTO create(@Valid WorldCreateDTO dto) {

		return null;
	}

	public WorldMirrorResponseDTO change(@Valid WorldChangeDTO dto) {

		return null;
	}

	public void remove(Long worldId) {
		
		repository.deleteById(worldId);
	}
}
