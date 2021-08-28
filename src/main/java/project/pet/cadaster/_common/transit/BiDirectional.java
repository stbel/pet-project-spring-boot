package project.pet.cadaster._common.transit;

import java.util.List;

public interface BiDirectional<ORIGINAL, REPRESENTATION> extends UniDirectional<ORIGINAL, REPRESENTATION> {

	ORIGINAL toOriginal(REPRESENTATION representation);

	List<ORIGINAL> toOriginal(List<REPRESENTATION> representation);
}
