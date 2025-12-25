package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.repositories.VisitRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VisitServiceTest {

    @Mock
    private VisitRepository visitRepository;

    @InjectMocks
    private VisitServiceImpl visitService;

    @Test
    void testCreateVisit() {

        Visit visit = new Visit();
        visit.setId(1L);
        visit.setDescription("Consulta general");

        when(visitRepository.save(any(Visit.class))).thenReturn(visit);

        Visit result = visitService.saveVisit(visit);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Consulta general", result.getDescription());
        verify(visitRepository, times(1)).save(visit);
    }


    @Test
    void testFindAllVisits() {

        Visit v1 = new Visit();
        v1.setId(1L);

        Visit v2 = new Visit();
        v2.setId(2L);

        List<Visit> visits = Arrays.asList(v1, v2);

        when(visitRepository.findAll()).thenReturn(visits);

        List<Visit> result = visitService.findAll();

        assertEquals(2, result.size());
        verify(visitRepository, times(1)).findAll();
    }

    @Test
    void testUpdateVisit() {

        Visit existingVisit = new Visit();
        existingVisit.setId(1L);
        existingVisit.setDescription("Consulta general");

        Visit updatedVisit = new Visit();
        updatedVisit.setId(1L);
        updatedVisit.setDescription("Consulta actualizada");

        when(visitRepository.save(any(Visit.class))).thenReturn(updatedVisit);

        Visit result = visitService.saveVisit(updatedVisit);

        assertNotNull(result);
        assertEquals("Consulta actualizada", result.getDescription());
        verify(visitRepository, times(1)).save(updatedVisit);
    }



}
