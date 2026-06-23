package com.tecsup.petclinic.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * Composite key for VetSpecialty entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VetSpecialtyId implements Serializable {

    private Integer vetId;
    private Integer specialtyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VetSpecialtyId that = (VetSpecialtyId) o;
        return Objects.equals(vetId, that.vetId) &&
                Objects.equals(specialtyId, that.specialtyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vetId, specialtyId);
    }
}