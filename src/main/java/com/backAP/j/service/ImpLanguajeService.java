package com.backAP.j.service;

import com.backAP.j.entity.Languaje;
import com.backAP.j.entity.Skill;
import com.backAP.j.interfaces.IntLanguajeService;
import com.backAP.j.repository.IntLanguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ImpLanguajeService{


    //@Autowired
    //public IntLanguajeRepository intLanguajeRepository;
    @Autowired
    IntLanguajeRepository intLanguajeRepository;

    public List<Languaje> getListLanguaje() {
        List<Languaje> listLan = intLanguajeRepository.findAll();
        return listLan;
    }

    public void saveLanguaje(Languaje languaje) {
        intLanguajeRepository.save(languaje);
    }

    public void deleteLanguajeById(Integer id) {
        intLanguajeRepository.deleteById(id);
    }

    public Optional<Languaje> findLanguajeById(Integer id) {return intLanguajeRepository.findById(id);}

    public boolean existsById(int id){ return intLanguajeRepository.existsById(id);}

    public Optional<Languaje> getByLanguaje(String languaje){return intLanguajeRepository.findByLanguaje(languaje);};
    public boolean existByLanguaje(String languaje){ return intLanguajeRepository.existsByLanguaje(languaje);}

}
