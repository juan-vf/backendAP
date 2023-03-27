package com.backAP.j.service;

import com.backAP.j.entity.Languaje;
import com.backAP.j.interfaces.IntLanguajeService;
import com.backAP.j.repository.IntLanguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ImpLanguajeService implements IntLanguajeService {


    @Autowired
    public IntLanguajeRepository intLanguajeRepository;

    @Override
    public List<Languaje> getListLanguaje() {
        List<Languaje> listLan = intLanguajeRepository.findAll();
        return listLan;
    }

    @Override
    public void saveLanguaje(Languaje languaje) {
        intLanguajeRepository.save(languaje);
    }

    @Override
    public void deleteLanguajeById(Integer id) {
        intLanguajeRepository.deleteById(id);
    }

    @Override
    public Languaje findLanguajeById(Integer id) {
        Languaje lan = intLanguajeRepository.findById(id).orElse(null);
        return lan;
    }

}
