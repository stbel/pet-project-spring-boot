package project.pet.cadaster.world.transit;

import org.mapstruct.Mapper;

import project.pet.cadaster._common.transit.UniDirectional;
import project.pet.cadaster.world.model.World;

@Mapper(componentModel = "spring")
public interface WorldMirrorMapper extends UniDirectional<World, WorldMirrorResponseDTO>{

}
