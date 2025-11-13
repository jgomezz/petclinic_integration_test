package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import java.util.List;

public interface VisitService {

    Visit saveVisit(Visit visit);

    Visit findVisitById(Long id);

    List<Visit> findAll();

    void deleteVisit(Long id);
}
