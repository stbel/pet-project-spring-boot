package project.pet.cadaster.story.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.pet.cadaster.story.model.Story;
import project.pet.cadaster.story.model.StoryRepository;
import project.pet.cadaster.story.transit.StoryChangeDTO;
import project.pet.cadaster.story.transit.StoryCreateDTO;
import project.pet.cadaster.story.transit.StoryFilterDTO;
import project.pet.cadaster.story.transit.StoryMirrorMapper;
import project.pet.cadaster.story.transit.StoryMirrorResponseDTO;

@Service
public class StoryService {

	@Autowired
	private StoryRepository repository;

	@Autowired
	private StoryMirrorMapper mapper;

	public List<StoryMirrorResponseDTO> listStory(StoryFilterDTO filter) {
		
		List<Story> list = repository.findAll();

		List<StoryMirrorResponseDTO> dtoList = mapper.toRepresentation(list);

		return dtoList;
	}

	public StoryMirrorResponseDTO find(Long storyId) {

		Optional<Story> optional = repository.findById(storyId);

		if (optional.isEmpty()) {
			return null;
		}

		return mapper.toRepresentation(optional.get());
	}

	public StoryMirrorResponseDTO create(@Valid StoryCreateDTO dto) {

		return null;
	}

	public StoryMirrorResponseDTO change(@Valid StoryChangeDTO dto) {

		return null;
	}

	public void remove(Long storyId) {
		
		repository.deleteById(storyId);
	}
}
