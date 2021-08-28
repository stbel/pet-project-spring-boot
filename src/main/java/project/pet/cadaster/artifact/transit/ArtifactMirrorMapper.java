package project.pet.cadaster.artifact.transit;

import org.mapstruct.Mapper;

import project.pet.cadaster._common.transit.UniDirectional;
import project.pet.cadaster.artifact.model.Artifact;

@Mapper(componentModel = "spring")
public interface ArtifactMirrorMapper extends UniDirectional<Artifact, ArtifactMirrorResponseDTO> {

}
