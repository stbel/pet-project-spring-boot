package project.pet.cadaster.world.controller;

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

import project.pet.cadaster.world.service.WorldService;
import project.pet.cadaster.world.transit.WorldChangeDTO;
import project.pet.cadaster.world.transit.WorldCreateDTO;
import project.pet.cadaster.world.transit.WorldFilterDTO;
import project.pet.cadaster.world.transit.WorldMirrorResponseDTO;

@RestController
@RequestMapping("/world")
public class WorldController {

	@Autowired
	private WorldService service;

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/index")
	public List<WorldMirrorResponseDTO> listWorld(WorldFilterDTO filter) {
		return service.listWorld(filter);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/find/{id}")
	public WorldMirrorResponseDTO findWorld(@PathVariable("id") Long worldId) {
		return service.find(worldId);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@CrossOrigin
	@PostMapping("/create")
	public WorldMirrorResponseDTO createWorld(@Valid WorldCreateDTO dto) {
		return service.create(dto);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@PutMapping("/change")
	public WorldMirrorResponseDTO changeWorld(@Valid WorldChangeDTO dto) {
		return service.change(dto);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@CrossOrigin
	@DeleteMapping("/remove/{id}")
	public void removeWorld(@PathVariable("id") Long worldId) {
		service.remove(worldId);
	}
}
