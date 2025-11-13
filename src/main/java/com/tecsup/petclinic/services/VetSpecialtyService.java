package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VetSpecialtyDTO;
import com.tecsup.petclinic.entities.VetSpecialty;
import com.tecsup.petclinic.exceptions.VetSpecialtyNotFoundException;

import java.util.List;

/**
 * Service interface for VetSpecialty operations
 */
public interface VetSpecialtyService {

    /**
     * Create a new vet-specialty relationship
     * @param vetSpecialtyDTO
     * @return
     */
    VetSpecialtyDTO create(VetSpecialtyDTO vetSpecialtyDTO);

    /**
     * Update an existing vet-specialty relationship
     * @param vetSpecialtyDTO
     * @return
     */
    VetSpecialtyDTO update(VetSpecialtyDTO vetSpecialtyDTO);

    /**
     * Delete a vet-specialty relationship
     * @param vetId
     * @param specialtyId
     * @throws VetSpecialtyNotFoundException
     */
    void delete(Integer vetId, Integer specialtyId) throws VetSpecialtyNotFoundException;

    /**
     * Find a specific vet-specialty relationship
     * @param vetId
     * @param specialtyId
     * @return
     * @throws VetSpecialtyNotFoundException
     */
    VetSpecialtyDTO findById(Integer vetId, Integer specialtyId) throws VetSpecialtyNotFoundException;

    /**
     * Find all specialties for a vet
     * @param vetId
     * @return
     */
    List<VetSpecialtyDTO> findByVetId(Integer vetId);

    /**
     * Find all vets with a specific specialty
     * @param specialtyId
     * @return
     */
    List<VetSpecialtyDTO> findBySpecialtyId(Integer specialtyId);

    /**
     * Find all vet-specialty relationships
     * @return
     */
    List<VetSpecialty> findAll();
}