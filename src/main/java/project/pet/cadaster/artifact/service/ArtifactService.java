package project.pet.cadaster.artifact.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.pet.cadaster.artifact.model.Artifact;
import project.pet.cadaster.artifact.model.ArtifactRepository;
import project.pet.cadaster.artifact.transit.ArtifactChangeDTO;
import project.pet.cadaster.artifact.transit.ArtifactCreateDTO;
import project.pet.cadaster.artifact.transit.ArtifactFilterDTO;
import project.pet.cadaster.artifact.transit.ArtifactMirrorMapper;
import project.pet.cadaster.artifact.transit.ArtifactMirrorResponseDTO;

@Service
public class ArtifactService {

	@Autowired
	private ArtifactRepository repository;

	@Autowired
	private ArtifactMirrorMapper mapper;

	public List<ArtifactMirrorResponseDTO> listArtifact(ArtifactFilterDTO filter) {

		List<Artifact> list = repository.findAll();

		List<ArtifactMirrorResponseDTO> dtoList = mapper.toRepresentation(list);

		return dtoList;
	}

	public ArtifactMirrorResponseDTO find(Long artifactId) {

		Optional<Artifact> optional = repository.findById(artifactId);

		if (optional.isEmpty()) {
			return null;
		}

		return mapper.toRepresentation(optional.get());
	}

	public ArtifactMirrorResponseDTO create(@Valid ArtifactCreateDTO dto) {

		return null;
	}

	public ArtifactMirrorResponseDTO change(@Valid ArtifactChangeDTO dto) {

		return null;
	}

	public void remove(Long artifactId) {

		repository.deleteById(artifactId);
	}
}
