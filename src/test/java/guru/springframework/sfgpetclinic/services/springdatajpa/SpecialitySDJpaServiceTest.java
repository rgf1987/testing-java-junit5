package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;

@ExtendWith(MockitoExtension.class)
class SpecialitySDJpaServiceTest {
	
	@Mock
	SpecialtyRepository specialtyRepository;
	
	@InjectMocks
	SpecialitySDJpaService service;
	
	@Test
	void testDeleteByObject() {
		Speciality speciality = new Speciality();
		service.delete(speciality);
		verify(specialtyRepository).delete(any(Speciality.class));
	}

	@Test
	void testFindById() {
		Speciality speciality = new Speciality();
		when(specialtyRepository.findById(1L)).thenReturn(Optional.of(speciality));
		
		Speciality foundSpeciality = service.findById(1L);
		
		assertNotNull(foundSpeciality);
		
		verify(specialtyRepository).findById(1L);
	}
	
	@Test
	void testDeleteById() {
		service.deleteById(1L);
		service.deleteById(1L);
		verify(specialtyRepository, times(2)).deleteById(1L);
	}
	
	@Test
	void deleteByIdAtLeast() {
		service.deleteById(1L);
		service.deleteById(1L);
		verify(specialtyRepository, atLeastOnce()).deleteById(1L);
	}
	
	@Test
	void deleteByIdAtMost() {
		service.deleteById(1L);
		service.deleteById(1L);
		verify(specialtyRepository, atMost(5)).deleteById(1L);
	}
	
	@Test
	void deleteByIdNever() {
		service.deleteById(1L);
		service.deleteById(1L);
		verify(specialtyRepository, never()).deleteById(5L);
	}
	
	@Test
	void testDelete() {
		service.delete(new Speciality());
	}

}
