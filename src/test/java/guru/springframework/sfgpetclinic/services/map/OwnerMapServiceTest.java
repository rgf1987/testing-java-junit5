package guru.springframework.sfgpetclinic.services.map;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;

class OwnerMapServiceTest {
	
	OwnerMapService ownerMapService;
	PetTypeService petTypeService;
	PetService petService;

	@BeforeEach
	void setUp() throws Exception {
		this.petService = new PetMapService();
		this.petTypeService = new PetTypeMapService();
		this.ownerMapService = new OwnerMapService(petTypeService, petService);
		
		System.out.println("First Before Each");
	}

	@DisplayName("Verify Zero Owners")
	@Test
	void ownersAreZero() {
		int ownerCount = ownerMapService.findAll().size();
		assertThat(ownerCount).isZero();
	}
	
	@DisplayName("Pet Type --")
	@Nested
	class TestCreatedPetTypes {
		
		@BeforeEach
		void setUp() {
			PetType petType = new PetType(1L, "Dog");
			PetType petType2 = new PetType(2L, "Cat");
			petTypeService.save(petType);
			petTypeService.save(petType2);
			
			System.out.println("Nested Before Each");
		}
		
		@Test
		void testPetCount() {
			int petTypeCount = petTypeService.findAll().size();
			assertThat(petTypeCount).isNotZero().isEqualTo(2);
		}
		
		@DisplayName("Save Owners Tests --")
		@Nested
		class SaveOwnersTest {
			@BeforeEach
			void setUp() {
				ownerMapService.save(new Owner(1L, "Before", "Each"));
				
				System.out.println("Nested2 Before Each");
			}
			
			@Test
			void saveOwner() {
				Owner owner = new Owner(2L, "Joe", "Buck");
				Owner savedOwner = ownerMapService.save(owner);
				assertThat(savedOwner).isNotNull();
			}
			
			@DisplayName("Find Owners Tests --")
			@Nested
			class FindOwnersTest {
								
				@Test
				void findOwner() {
					Owner foundOwner = ownerMapService.findById(1L);
					assertThat(foundOwner).isNotNull();
				}
				
				@Test
				void findOwnerNotFound() {
					Owner foundOwner = ownerMapService.findById(2L);
					assertThat(foundOwner).isNull();
				}
			}
		}
		
	}
	
	@DisplayName("Verify Still Zero Owners")
	@Test
	void ownersAreStillZero() {
		int ownerCount = ownerMapService.findAll().size();
		assertThat(ownerCount).isZero();
	}
	

}
