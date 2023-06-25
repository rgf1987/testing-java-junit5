package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;

@Disabled(value = "Disabled until we learn Mocking")
class OwnerSDJpaServiceTest {
	
	OwnerSDJpaService service;

	@BeforeEach
	void setUp() throws Exception {
		service = new OwnerSDJpaService(null,null,null);
	}

	@Disabled
	@Test
	void testFindByLastName() {
		Owner foundOwner = service.findByLastName("Buck");
	}

	@Test
	void testFindAllByLastNameLike() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

}
