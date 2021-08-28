package project.pet.cadaster.place.transit;

import javax.validation.constraints.NotBlank;

public class PlaceCreateDTO {

	@NotBlank
	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
