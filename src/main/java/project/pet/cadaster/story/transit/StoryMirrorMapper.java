package project.pet.cadaster.story.transit;

import org.mapstruct.Mapper;

import project.pet.cadaster._common.transit.UniDirectional;
import project.pet.cadaster.story.model.Story;

@Mapper(componentModel = "spring")
public interface StoryMirrorMapper extends UniDirectional<Story, StoryMirrorResponseDTO> {

}
