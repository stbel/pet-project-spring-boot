package project.pet.cadaster.story.controller;

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

import project.pet.cadaster.story.service.StoryService;
import project.pet.cadaster.story.transit.StoryChangeDTO;
import project.pet.cadaster.story.transit.StoryCreateDTO;
import project.pet.cadaster.story.transit.StoryFilterDTO;
import project.pet.cadaster.story.transit.StoryMirrorResponseDTO;

@RestController
@RequestMapping("/story")
public class StoryController {

	@Autowired
	private StoryService service;

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/index")
	public List<StoryMirrorResponseDTO> listStory(StoryFilterDTO filter) {
		return service.listStory(filter);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@GetMapping("/find/{id}")
	public StoryMirrorResponseDTO findStory(@PathVariable("id") Long storyId) {
		return service.find(storyId);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@CrossOrigin
	@PostMapping("/create")
	public StoryMirrorResponseDTO createStory(@Valid StoryCreateDTO dto) {
		return service.create(dto);
	}

	@ResponseStatus(code = HttpStatus.OK)
	@CrossOrigin
	@PutMapping("/change")
	public StoryMirrorResponseDTO changeStory(@Valid StoryChangeDTO dto) {
		return service.change(dto);
	}

	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@CrossOrigin
	@DeleteMapping("/remove/{id}")
	public void removeStory(@PathVariable("id") Long storyId) {
		service.remove(storyId);
	}
}
