package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.doThrow;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {
	
	@Mock
	VisitRepository visitRepository;
	
	@InjectMocks 
	VisitSDJpaService visitSDJpaService;

	@Test
	void testFindAll() {
		//given
		Visit visit = new Visit();
		Set<Visit> visits = new HashSet<Visit>();
		visits.add(visit);
		given(visitRepository.findAll()).willReturn(visits);
		//when
		Set<Visit> foundVisits = visitSDJpaService.findAll();
		//then
		assertThat(foundVisits).hasSize(1);
		then(visitRepository).should().findAll();		
	}

	@Test
	void testFindById() {
		//given
		Visit visit = new Visit();		
		given(visitRepository.findById(anyLong())).willReturn(Optional.of(visit));
		//when
		Visit foundVisit = visitSDJpaService.findById(1L);
		//then
		assertThat(foundVisit).isNotNull();
		then(visitRepository).should().findById(anyLong());
	}

	@Test
	void testSave() {
		//given
		Visit visit = new Visit();		
		given(visitRepository.save(any(Visit.class))).willReturn(visit);
		//when
		Visit savedVisit = visitSDJpaService.save(new Visit());
		//then
		assertThat(savedVisit).isNotNull();
		then(visitRepository).should().save(any(Visit.class));
	}

	@Test
	void testDelete() {
		//given - none
		//when
		visitSDJpaService.delete(new Visit());
		//then
		then(visitRepository).should().delete(any(Visit.class));
	}

	@Test
	void testDeleteById() {
		//given - none
		//when
		visitSDJpaService.deleteById(1L);
		//then
		then(visitRepository).should().deleteById(anyLong());
	}
}
