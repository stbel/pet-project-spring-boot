package project.pet.cadaster.place.controller;

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

import project.pet.cadaster.place.service.PlaceService;
import project.pet.cadaster.place.transit.PlaceChangeDTO;
import project.pet.cadaster.place.transit.PlaceCreateDTO;
import project.pet.cadaster.place.transit.PlaceFilterDTO;
import project.pet.cadaster.place.transit.PlaceMirrorResponseDTO;

@RestController
@RequestMapping("/place")
public class PlaceController {

	@Autowired
	private PlaceService service;
	
	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/index")
	public List<PlaceMirrorResponseDTO> listPlace(PlaceFilterDTO filter) {
		return null;
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/find/{id}")
	public PlaceMirrorResponseDTO findPlace(@PathVariable("id") Long placeId) {
		return null;
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@CrossOrigin
	@PostMapping("/create")
	public PlaceMirrorResponseDTO createPlace(@Valid PlaceCreateDTO dto) {
		return null;
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@PutMapping("/change")
	public PlaceMirrorResponseDTO changePlace(@Valid PlaceChangeDTO dto) {
		return null;
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@CrossOrigin
	@DeleteMapping("/remove/{id}")
	public void removePlace(@PathVariable("id") Long placeId) {

	}
}
