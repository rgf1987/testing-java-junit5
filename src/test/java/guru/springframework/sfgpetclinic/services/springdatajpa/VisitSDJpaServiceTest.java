package guru.springframework.sfgpetclinic.services.springdatajpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
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

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {
	
	@Mock
	VisitRepository visitRepository;
	
	@InjectMocks 
	VisitSDJpaService visitSDJpaService;

	@Test
	void testFindAll() {

		Visit visit = new Visit();
		Set<Visit> visits = new HashSet<Visit>();
		visits.add(visit);
		
		when(visitRepository.findAll()).thenReturn(visits);
		
		Set<Visit> foundVisits = visitSDJpaService.findAll();
		
		verify(visitRepository).findAll();
		
		assertThat(foundVisits).hasSize(1);
	}

	@Test
	void testFindById() {
		Visit visit = new Visit();
		
		when(visitRepository.findById(anyLong())).thenReturn(Optional.of(visit));
		
		Visit foundVisit = visitSDJpaService.findById(1L);
		
		verify(visitRepository).findById(anyLong());
		
		assertThat(foundVisit).isNotNull();
		
	}

	@Test
	void testSave() {
		Visit visit = new Visit();
		
		when(visitRepository.save(any(Visit.class))).thenReturn(visit);
		
		Visit savedVisit = visitSDJpaService.save(new Visit());
		
		verify(visitRepository).save(any(Visit.class));
		
		assertThat(savedVisit).isNotNull();
	}

	@Test
	void testDelete() {
		Visit visit = new Visit();

		visitSDJpaService.delete(visit);
		
		verify(visitRepository).delete(any(Visit.class));
	}

	@Test
	void testDeleteById() {
		visitSDJpaService.deleteById(1L);
		
		verify(visitRepository).deleteById(anyLong());
	}

}
