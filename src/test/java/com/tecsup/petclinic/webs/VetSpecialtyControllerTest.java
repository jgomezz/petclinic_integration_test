package com.tecsup.petclinic.webs;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for VetSpecialtyController
 */
@AutoConfigureMockMvc
@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VetSpecialtyControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    private static Long vetId = 1L;       // Suponiendo que ya existen
    private static Long specialtyId = 1L; // valores válidos en la BD


    /**
     * Test to find the created vet-specialty (OK case)
     */
    @Test
    @Order(2)
    public void testFindVetSpecialtyOK() throws Exception {
        mockMvc.perform(get("/vet-specialties/{vetId}/{specialtyId}", vetId, specialtyId)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vetId", is(vetId.intValue())))
                .andExpect(jsonPath("$.specialtyId", is(specialtyId.intValue())));
    }

    /**
     * Test to find a vet specialty that doesn't exist (KO case)
     */
    @Test
    @Order(3)
    public void testFindVetSpecialtyKO() throws Exception {
        mockMvc.perform(get("/vet-specialties/999/999"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    /**
     *Get specialties for a vet that doesn't exist
     */
    @Test
    @Order(4)
    public void testFindByVetIdKO() throws Exception {
        mockMvc.perform(get("/vet-specialties/vet/999"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }

    /**
     *  Get vets for a specialty that doesn't exist
     */
    @Test
    @Order(5)
    public void testFindBySpecialtyIdKO() throws Exception {
        mockMvc.perform(get("/vet-specialties/specialty/999"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());
    }


    /**
     * Test to delete an existing vet-specialty (OK case)
     */
    @Test
    @Order(6)
    public void testDeleteVetSpecialtyOK() throws Exception {
        mockMvc.perform(delete("/vet-specialties/{vetId}/{specialtyId}", vetId, specialtyId))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test to delete a non-existent vet specialty (KO case)
     */
    @Test
    @Order(7)
    public void testDeleteVetSpecialtyKO() throws Exception {
        mockMvc.perform(delete("/vet-specialties/999/999"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
