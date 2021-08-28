package project.pet.cadaster.place.transit;

import org.mapstruct.Mapper;

import project.pet.cadaster._common.transit.UniDirectional;
import project.pet.cadaster.place.model.Place;

@Mapper(componentModel = "spring")
public interface PlaceMirrorMapper extends UniDirectional<Place, PlaceMirrorResponseDTO> {

}
