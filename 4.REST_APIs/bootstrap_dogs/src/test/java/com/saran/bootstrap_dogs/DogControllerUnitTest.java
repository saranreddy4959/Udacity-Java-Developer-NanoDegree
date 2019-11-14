package com.saran.bootstrap_dogs;


import com.saran.bootstrap_dogs.controller.DogController;
import com.saran.bootstrap_dogs.service.DogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DogService dogService;

    @WithMockUser(username = "admin")
    @Test
    public void getAllDogs() throws Exception {
        mockMvc.perform(get("/dogs"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retreiveAllDogs();
    }

    @WithMockUser(username = "admin")
    @Test
    public void getDogBreeds() throws Exception {
        mockMvc.perform(get("/dogs/breed"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retreiveBreed();
    }

    @WithMockUser(username = "admin")
    @Test
    public void getBreedById() throws Exception {
        mockMvc.perform(get("/2/breed"))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retreiveDogBreedById(Long.valueOf(2));
    }


}
