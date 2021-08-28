package project.pet.cadaster.artifact.controller;

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

import project.pet.cadaster.artifact.service.ArtifactService;
import project.pet.cadaster.artifact.transit.ArtifactChangeDTO;
import project.pet.cadaster.artifact.transit.ArtifactCreateDTO;
import project.pet.cadaster.artifact.transit.ArtifactFilterDTO;
import project.pet.cadaster.artifact.transit.ArtifactMirrorResponseDTO;

@RestController
@RequestMapping("/artifact")
public class ArtifactController {

	@Autowired
	private ArtifactService service;

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/index")
	public List<ArtifactMirrorResponseDTO> listArtifact(ArtifactFilterDTO filter) {
		return service.listArtifact(filter);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/find/{id}")
	public ArtifactMirrorResponseDTO findArtifact(@PathVariable("id") Long artifactId) {
		return service.find(artifactId);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@CrossOrigin
	@PostMapping("/create")
	public ArtifactMirrorResponseDTO createArtifact(@Valid ArtifactCreateDTO dto) {
		return service.create(dto);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@PutMapping("/change")
	public ArtifactMirrorResponseDTO changeArtifact(@Valid ArtifactChangeDTO dto) {
		return service.change(dto);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@CrossOrigin
	@DeleteMapping("/remove/{id}")
	public void removeArtifact(@PathVariable("id") Long artifactId) {
		service.remove(artifactId);
	}
}
