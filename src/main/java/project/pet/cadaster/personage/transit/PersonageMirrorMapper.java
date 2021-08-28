package project.pet.cadaster.personage.transit;

import org.mapstruct.Mapper;

import project.pet.cadaster._common.transit.UniDirectional;
import project.pet.cadaster.personage.model.Personage;

@Mapper(componentModel = "spring")
public interface PersonageMirrorMapper extends UniDirectional<Personage, PersonageMirrorResponseDTO> {

}
