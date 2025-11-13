package com.tecsup.petclinic.webs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.tecsup.petclinic.dtos.VetSpecialtyDTO;
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
import org.springframework.test.web.servlet.ResultActions;

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

    private static Long createdVetId;
    private static Long createdSpecialtyId;

    /**
     * Test to create a new vet-specialty relationship (OK case)
     */

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
     * Test to delete an existing vet-specialty (OK case)
     */
    @Test
    @Order(5)
    public void testDeleteVetSpecialtyOK() throws Exception {
        mockMvc.perform(delete("/vet-specialties/{vetId}/{specialtyId}", vetId, specialtyId))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /**
     * Test to delete a non-existent vet specialty (KO case)
     */
    @Test
    @Order(6)
    public void testDeleteVetSpecialtyKO() throws Exception {
        mockMvc.perform(delete("/vet-specialties/999/999"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}
