package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.VetSpecialty;
import com.tecsup.petclinic.entities.VetSpecialtyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for VetSpecialty entity
 */
@Repository
public interface VetSpecialtyRepository extends JpaRepository<VetSpecialty, VetSpecialtyId> {

    // Find all specialties by vet ID
    List<VetSpecialty> findByVetId(Integer vetId);

    // Find all vets by specialty ID
    List<VetSpecialty> findBySpecialtyId(Integer specialtyId);

    // Find primary specialty for a vet
    List<VetSpecialty> findByVetIdAndIsPrimary(Integer vetId, Boolean isPrimary);

    @Override
    List<VetSpecialty> findAll();
}