package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

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
		//given
		Speciality speciality = new Speciality();
		//when
		service.delete(speciality);
		//then
		then(specialtyRepository).should().delete(any(Speciality.class));
	}

	@Test
	void testFindById() {
		//given
		Speciality speciality = new Speciality();
		given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality));
		//when
		Speciality foundSpeciality = service.findById(1L);
		//then
		assertNotNull(foundSpeciality);		
		then(specialtyRepository).should().findById(1L);
	}
	
	@Test
	void testFindByIdBdd() {
		//given
		Speciality speciality = new Speciality();		
		given(specialtyRepository.findById(1L)).willReturn(Optional.of(speciality));
		
		//when
		Speciality foundSpeciality = service.findById(1L);
		
		//then
		assertThat(foundSpeciality).isNotNull();		
		then(specialtyRepository).should().findById(anyLong());
		then(specialtyRepository).shouldHaveNoMoreInteractions();
		
	}
	
	@Test
	void testDeleteById() {
		//given -none
		//when
		service.deleteById(1L);
		service.deleteById(1L);
		//then		
		then(specialtyRepository).should(times(2)).deleteById(1L);
	}
	
	@Test
	void deleteByIdAtLeast() {
		//given -none
		//when
		service.deleteById(1L);
		service.deleteById(1L);
		//then
		then(specialtyRepository).should(atLeastOnce()).deleteById(1L);
	}
	
	@Test
	void deleteByIdAtMost() {
		//given-none
		//when
		service.deleteById(1L);
		service.deleteById(1L);
		//then
		then(specialtyRepository).should(atMost(5)).deleteById(1L);
	}
	
	@Test
	void deleteByIdNever() {
		//given -none
		//when
		service.deleteById(1L);
		service.deleteById(1L);
		//then
		then(specialtyRepository).should(never()).deleteById(5L);
	}
	
	@Test
	void testDelete() {
		//given -none
		//when
		service.delete(new Speciality());
		//then
		then(specialtyRepository).should().delete(any(Speciality.class));
	}

}
