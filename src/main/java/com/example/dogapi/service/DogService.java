package com.example.dogapi.service;

import com.example.dogapi.entity.Dog;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
}
