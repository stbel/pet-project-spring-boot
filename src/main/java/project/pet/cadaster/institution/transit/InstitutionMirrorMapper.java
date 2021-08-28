package project.pet.cadaster.institution.transit;

import org.mapstruct.Mapper;

import project.pet.cadaster._common.transit.UniDirectional;
import project.pet.cadaster.institution.model.Institution;

@Mapper(componentModel = "spring")
public interface InstitutionMirrorMapper extends UniDirectional<Institution, InstitutionMirrorResponseDTO>{

}
