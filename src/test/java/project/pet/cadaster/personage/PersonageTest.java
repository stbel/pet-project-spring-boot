package project.pet.cadaster.personage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.pet.cadaster.personage.model.Personage;
import project.pet.cadaster.personage.model.PersonageRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PersonageTest {

	private static String[] data = { "Agis XIV", "Arbin Maren", "Arkady Darell", "Arkady Darell", "Bail Channis",
			"Bayta Darell", "Bel Riose", "Bel Riose", "Bliss", "Cleon I", "Cleon II", "Dagobert IX", "David Starr",
			"Dors Venabili", "Ducem Barr", "Ebling Mis", "Edard I", "Elijah Baley", "Eskel Gorov", "Eto Demerzel",
			"Fallom", "Frankenn I", "Gaal Dornick", "Gaia", "Gladia", "Golan Trevize", "Grew", "Han Pritcher",
			"Hari Seldon", "Hari Seldon", "Hober Mallow", "Janov Pelorat", "Jezebel Baley", "Jole Turbor",
			"Joseph Schwartz", "Jothan Leebig", "Lathan Devers", "Lepold I", "Loa Maren", "Lord Stettin",
			"Mother Rittah", "Noys Lambent", "Poly Verisof", "Preem Palver", "R. Daneel Olivaw", "R. Giskard Reventlov",
			"Rashelle", "Raych Seldon", "Dors Venabili", "Salvor Hardin", "Sef Sermak", "Stanel VI", "Stannell II",
			"Tennar", "The Mule", "Toran Darell", "Toran Darell II", "Traders", "Vasilia Aliena", "Wanda Seldon",
			"Wienis", "Yohan Lee", "Yugo Amaryl" };

	@Autowired
	private PersonageRepository repository;
	
	@Test
	@Order(1)
	public void loadData() {

		if (repository.findAll().size() == 0) {

			List<Personage> list = new ArrayList<Personage>();

			for (String string : data) {
				Personage personage = new Personage();
				personage.setName(string);
				personage.setDescription(string + " description");
				list.add(personage);
			}

			repository.saveAll(list);
		}
	}

	@Test
	@Order(2)
	public void indexTest() {
		
		List<Personage> list = repository.findAll();
		assertThat(list.size() == data.length).isTrue();
	}
}
