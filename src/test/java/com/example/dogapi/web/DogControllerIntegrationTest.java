package com.example.dogapi.web;

import com.example.dogapi.entity.Dog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DogControllerIntegrationTest {

    @LocalServerPort
    private int port;

//    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() throws MalformedURLException{
        restTemplate = new TestRestTemplate("admin", "password");

    }
    @Test
    public void getAllDogs(){
        ResponseEntity<List> response = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/dogs", List.class
        );

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getDogBreeds(){
        ResponseEntity<List> response = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/dogs/breed", List.class
        );

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
    @Test
    public void getDogNames(){
        ResponseEntity<List> response = this.restTemplate.getForEntity(
                "http://localhost:" + port + "/dogs/name", List.class
        );

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getBreedByID() {
        ResponseEntity<String> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/1/breed", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
