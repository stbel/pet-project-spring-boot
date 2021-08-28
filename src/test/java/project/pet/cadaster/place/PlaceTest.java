package project.pet.cadaster.place;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import project.pet.cadaster.place.model.Place;
import project.pet.cadaster.place.model.PlaceRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PlaceTest {

	@Autowired
	private PlaceRepository repository;
	
	private static String[] data = { "Achilles", "Alpha Centauri", "Anacreon", "Anacreon Province", "Arcturus",
			"Aurora", "Billibotton district", "Chica", "Dahl district", "Earth", "Gaia", "Imperial Library", "Jennisek",
			"Korell", "Mycogen district", "Santanni", "Sayshell", "Sayshell Sector", "Senloo", "Smyrno", "Solaria",
			"Streeling District", "Streeling University", "Terminus", "The Periphery", "Trantor", "Wye district",
			"Ziggoreth district" };
	
	@Test
	@Order(1)
	public void loadData() {

		if (repository.findAll().size() == 0) {

			List<Place> list = new ArrayList<>();

			for (String string : data) {
				Place place = new Place();
				place.setName(string);
				place.setDescription(string + " description");
				list.add(place);
			}

			repository.saveAll(list);
		}
	}

	@Test
	@Order(2)
	public void indexTest() {
		List<Place> list = repository.findAll();
		assertThat(list.size() == data.length).isTrue();
	}
}
