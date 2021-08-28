package project.pet.cadaster.personage;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import project.pet.cadaster.personage.model.Personage;
import project.pet.cadaster.personage.model.PersonageRepository;
import project.pet.cadaster.personage.transit.PersonageMirrorMapper;
import project.pet.cadaster.personage.transit.PersonageMirrorResponseDTO;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PersonageTest {

	private static String[] personages = { "Agis XIV", "Arbin Maren", "Arkady Darell", "Arkady Darell", "Bail Channis",
			"Bayta Darell", "Bel Riose", "Bel Riose", "Bliss", "Cleon I", "Cleon II", "Dagobert IX", "David Starr",
			"Dors Venabili", "Ducem Barr", "Ebling Mis", "Edard I", "Elijah Baley", "Eskel Gorov", "Eto Demerzel",
			"Fallom", "Frankenn I", "Gaal Dornick", "Gaia", "Gladia", "Golan Trevize", "Grew", "Han Pritcher",
			"Hari Seldon", "Hari Seldon", "Hober Mallow", "Janov Pelorat", "Jezebel Baley", "Jole Turbor",
			"Joseph Schwartz", "Jothan Leebig", "Lathan Devers", "Lepold I", "Loa Maren", "Lord Stettin",
			"Mother Rittah", "Noys Lambent", "Poly Verisof", "Preem Palver", "R. Daneel Olivaw", "R. Giskard Reventlov",
			"Rashelle", "Raych Seldon", "Dors Venabili", "Salvor Hardin", "Sef Sermak", "Stanel VI", "Stannell II",
			"Tennar", "The Mule", "Toran Darell", "Toran Darell II", "Traders", "Vasilia Aliena", "Wanda Seldon",
			"Wienis", "Yohan Lee", "Yugo Amaryl" };

	private static String[] places = { "Achilles", "Alpha Centauri", "Anacreon", "Anacreon Province", "Arcturus",
			"Aurora", "Billibotton district", "Chica", "Dahl district", "Earth", "Gaia", "Imperial Library", "Jennisek",
			"Korell", "Mycogen district", "Santanni", "Sayshell", "Sayshell Sector", "Senloo", "Smyrno", "Solaria",
			"Streeling District", "Streeling University", "Terminus", "The Periphery", "Trantor", "Wye district",
			"Ziggoreth district" };

	private static String[] institutions = { "Anacreon Kingdom", "First Foundation", "Second Foundation",
			"Galactic Empire", "Galactic Empire", "Sayshell Union", "Union of Worlds" };

	@Autowired
	private PersonageRepository repository;

	@Autowired
	private PersonageMirrorMapper mapper;

	@Test
	@Order(1)
	public void loadData() {

		if (repository.findAll().size() == 0) {

			List<Personage> list = new ArrayList<Personage>();

			for (String string : personages) {
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

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());

		List<PersonageMirrorResponseDTO> representationDTO = mapper.toRepresentation(list);

		representationDTO.stream().forEach(dto -> {

			try {
				System.out.println(objectMapper.writeValueAsString(dto));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		});
	}
}
