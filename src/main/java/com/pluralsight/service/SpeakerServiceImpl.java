package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepository repository;

    @Override
    public List<Speaker> findAll(){

        return repository.findAll();
    }

    // Setter Injection: Repository injected instead of hard coded
    public void setRepository(SpeakerRepository repository) {
        this.repository = repository;
    }
}
