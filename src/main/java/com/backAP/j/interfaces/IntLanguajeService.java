package com.backAP.j.interfaces;

import com.backAP.j.entity.Languaje;

import java.util.List;

public interface IntLanguajeService {
    //get Languaje List
    public List<Languaje> getListLanguaje();

    //save Languaje class
    public void saveLanguaje(Languaje languaje);

    //delete Languaje
    public void deleteLanguajeById(Integer id);

    //find Languaje by id
    public Languaje findLanguajeById(Integer id);
}
