package com.gerencia.prexixion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerencia.prexixion.models.Personal;
import com.gerencia.prexixion.repositories.PersonalRepository;

@Service
public class PersonalService {

    private final PersonalRepository personalRepository;

    @Autowired
    public PersonalService(PersonalRepository personalRepository){
        this.personalRepository = personalRepository;
    }

    public Personal login(String dni, String clave) throws Exception{
        return personalRepository.login(dni, clave);
    }
}
