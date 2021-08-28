package project.pet.cadaster.story.transit;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StoryMirrorResponseDTO {
	private Long id;

	private String name;

	private String description;

	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime createdAt;

	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private LocalDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
