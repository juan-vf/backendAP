package com.backAP.j.service;

import com.backAP.j.entity.About;
import com.backAP.j.entity.Experience;
import com.backAP.j.interfaces.IntAboutService;
import com.backAP.j.repository.IntAboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ImpAboutService{

    @Autowired
    private IntAboutRepository intAboutRepository ;

    public List<About> getListAbout() {
        List<About> listAbouts = intAboutRepository.findAll();
        return listAbouts;
    }

    public void saveAbout(About about) {
        intAboutRepository.save(about);
    }

    public void deleteAboutById(Integer id) {
        intAboutRepository.deleteById(id);
    }

    public Optional<About> getByTittleAbout(String tittleAbout){
        return intAboutRepository.findByTittleAbout(tittleAbout);
    }

    public Optional<About> findAboutById(Integer id) {
        return intAboutRepository.findById(id);

    }
    public boolean existsById(int id){
        return intAboutRepository.existsById(id);
    }
    public boolean existByTittleAbout(String tittleAbout){
        return intAboutRepository.existsByTittleAbout(tittleAbout);
    }

}
