package project.pet.cadaster.institution;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.pet.cadaster.institution.model.Institution;
import project.pet.cadaster.institution.model.InstitutionRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class InstitutionTest {
	private static String[] data = { "Anacreon Kingdom", "First Foundation", "Second Foundation", "Galactic Empire",
			"Galactic Empire", "Sayshell Union", "Union of Worlds" };

	@Autowired
	private InstitutionRepository repository;

	@Test
	@Order(1)
	public void loadData() {

		if (repository.findAll().size() == 0) {

			List<Institution> list = new ArrayList<Institution>();

			for (String string : data) {
				Institution institution = new Institution();
				institution.setName(string);
				institution.setDescription(string + " description");
				list.add(institution);
			}

			repository.saveAll(list);
		}
	}

	@Test
	@Order(2)
	public void indexTest() {

		List<Institution> list = repository.findAll();
		assertThat(list.size() == data.length).isTrue();
	}
}
