package com.tecsup.petclinic.services;

import com.tecsup.petclinic.dtos.VetSpecialtyDTO;
import com.tecsup.petclinic.entities.VetSpecialty;
import com.tecsup.petclinic.entities.VetSpecialtyId;
import com.tecsup.petclinic.exceptions.VetSpecialtyNotFoundException;
import com.tecsup.petclinic.mapper.VetSpecialtyMapper;
import com.tecsup.petclinic.repositories.VetSpecialtyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service implementation for VetSpecialty operations
 */
@Service
@Slf4j
public class VetSpecialtyServiceImpl implements VetSpecialtyService {

    private final VetSpecialtyRepository vetSpecialtyRepository;
    private final VetSpecialtyMapper vetSpecialtyMapper;

    public VetSpecialtyServiceImpl(VetSpecialtyRepository vetSpecialtyRepository,
                                   VetSpecialtyMapper vetSpecialtyMapper) {
        this.vetSpecialtyRepository = vetSpecialtyRepository;
        this.vetSpecialtyMapper = vetSpecialtyMapper;
    }

    @Override
    public VetSpecialtyDTO create(VetSpecialtyDTO vetSpecialtyDTO) {
        VetSpecialty newVetSpecialty = vetSpecialtyRepository.save(
                vetSpecialtyMapper.mapToEntity(vetSpecialtyDTO)
        );
        return vetSpecialtyMapper.mapToDto(newVetSpecialty);
    }

    @Override
    public VetSpecialtyDTO update(VetSpecialtyDTO vetSpecialtyDTO) {
        VetSpecialty updatedVetSpecialty = vetSpecialtyRepository.save(
                vetSpecialtyMapper.mapToEntity(vetSpecialtyDTO)
        );
        return vetSpecialtyMapper.mapToDto(updatedVetSpecialty);
    }

    @Override
    public void delete(Integer vetId, Integer specialtyId) throws VetSpecialtyNotFoundException {
        VetSpecialtyDTO vetSpecialty = findById(vetId, specialtyId);
        vetSpecialtyRepository.delete(vetSpecialtyMapper.mapToEntity(vetSpecialty));
    }

    @Override
    public VetSpecialtyDTO findById(Integer vetId, Integer specialtyId)
            throws VetSpecialtyNotFoundException {
        VetSpecialtyId id = new VetSpecialtyId(vetId, specialtyId);
        Optional<VetSpecialty> vetSpecialty = vetSpecialtyRepository.findById(id);

        if (!vetSpecialty.isPresent()) {
            throw new VetSpecialtyNotFoundException("VetSpecialty not found for vetId: "
                    + vetId + " and specialtyId: " + specialtyId);
        }

        return vetSpecialtyMapper.mapToDto(vetSpecialty.get());
    }

    @Override
    public List<VetSpecialtyDTO> findByVetId(Integer vetId) {
        List<VetSpecialty> vetSpecialties = vetSpecialtyRepository.findByVetId(vetId);
        vetSpecialties.forEach(vs -> log.info("" + vs));

        return vetSpecialties.stream()
                .map(vetSpecialtyMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VetSpecialtyDTO> findBySpecialtyId(Integer specialtyId) {
        List<VetSpecialty> vetSpecialties = vetSpecialtyRepository.findBySpecialtyId(specialtyId);
        vetSpecialties.forEach(vs -> log.info("" + vs));

        return vetSpecialties.stream()
                .map(vetSpecialtyMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<VetSpecialty> findAll() {
        return vetSpecialtyRepository.findAll();
    }
}