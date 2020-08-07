package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    // Punto dolente del codice: se cambio implementazione devo rciompilare tutto l'applicativo
    private SpeakerRepository repository = new HibernateSpeakerRepositoryImpl();

    @Override
    public List<Speaker> findAll(){

        return repository.findAll();
    }

}
