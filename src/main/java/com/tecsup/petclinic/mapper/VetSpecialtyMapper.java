package com.tecsup.petclinic.mapper;

import com.tecsup.petclinic.dtos.VetSpecialtyDTO;
import com.tecsup.petclinic.entities.VetSpecialty;
import org.springframework.stereotype.Component;

@Component
public class VetSpecialtyMapper {

    /**
     * Convert DTO to Entity
     * @param dto
     * @return
     */
    public VetSpecialty mapToEntity(VetSpecialtyDTO dto) {
        if (dto == null) return null;
        return new VetSpecialty(
                dto.getVetId(),
                dto.getSpecialtyId(),
                dto.getCertificationDate(),
                dto.getYearsExperience(),
                dto.getIsPrimary(),
                dto.getNotes()
        );
    }

    /**
     * Convert Entity to DTO
     * @param entity
     * @return
     */
    public VetSpecialtyDTO mapToDto(VetSpecialty entity) {
        if (entity == null) return null;
        return new VetSpecialtyDTO(
                entity.getVetId(),
                entity.getSpecialtyId(),
                entity.getCertificationDate(),
                entity.getYearsExperience(),
                entity.getIsPrimary(),
                entity.getNotes()
        );
    }
}