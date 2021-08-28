package project.pet.cadaster._common.transit;

import java.util.List;

public interface UniDirectional <ORIGINAL, REPRESENTATION> {
	
	REPRESENTATION toRepresentation(ORIGINAL original);
	
	List<REPRESENTATION> toRepresentation(List<ORIGINAL> original);
}
