package com.saran.bootstrap_dogs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTesting {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate("admin", "password");

    //@WithMockUser(username = "admin")
    @Test
    public void getAllDogs() throws Exception{
        ResponseEntity<List> response =
                this.restTemplate.getForEntity("http://localhost:"+ port +"/dogs", List.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }




}
