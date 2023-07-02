package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;

@ExtendWith(MockitoExtension.class)
class VetSDJpaServiceTest {
	
	@Mock
	VetRepository vetRepository;
	
	@InjectMocks
	VetSDJpaService service;

	@Test
	void testFindAll() {
		Speciality speciality = new Speciality();
		Set<Speciality> specialities = new HashSet<Speciality>();
		specialities.add(speciality);		
		//Vet vet = new Vet(1l, "Ruben", "Gonzalez", specialities);	
		
		when(vetRepository.findAll()).thenReturn(new HashSet<Vet>());
		
		Set<Vet> foundVets  = service.findAll();
		
		assertNotNull(foundVets);
	}

	@Test
	void testFindById() {
		Speciality speciality = new Speciality();
		Set<Speciality> specialities = new HashSet<Speciality>();
		specialities.add(speciality);		
		Vet vet = new Vet(1l, "Ruben", "Gonzalez", specialities);		
		
		when(vetRepository.findById(1L)).thenReturn(Optional.of(vet));
		
		Vet foundVet  = service.findById(1L);
		
		assertNotNull(foundVet);
		
		verify(vetRepository).findById(1L);
	}

	@Test
	void testSave() {
		Speciality speciality = new Speciality();
		Set<Speciality> specialities = new HashSet<Speciality>();
		specialities.add(speciality);		
		Vet vet = new Vet(1l, "Ruben", "Gonzalez", specialities);
		
		when(vetRepository.save(vet)).thenReturn(vet);
		
		Vet vetSaved = service.save(vet);
		
		assertNotNull(vetSaved);
		
		verify(vetRepository).save(vetSaved);
	}

	@Test
	void testDelete() {
		Speciality speciality = new Speciality();
		Set<Speciality> specialities = new HashSet<Speciality>();
		specialities.add(speciality);		
		Vet vet = new Vet(1l, "Ruben", "Gonzalez", specialities);
		
		service.delete(vet);
		
		verify(vetRepository).delete(vet);
	}

	@Test
	void testDeleteById() {
		service.deleteById(1L);
		
		verify(vetRepository, atLeastOnce()).deleteById(1L);
	}

}
