package com.backAP.j.service;

import com.backAP.j.entity.About;
import com.backAP.j.interfaces.IntAboutService;
import com.backAP.j.repository.IntAboutRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ImpAboutService implements IntAboutService {

    @Autowired
    private IntAboutRepository intAboutRepository ;

    @Override
    public List<About> getListAbout() {
        List<About> listAbouts = intAboutRepository.findAll();
        return listAbouts;
    }

    @Override
    public void saveAbout(About about) {
        intAboutRepository.save(about);
    }

    @Override
    public void deleteAboutById(Integer id) {
        intAboutRepository.deleteById(id);
    }

    @Override
    public About findAboutById(Integer id) {
        About about = intAboutRepository.findById(id).orElse(null);
        return about;
    }

}
