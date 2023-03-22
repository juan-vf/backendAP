package com.backAP.j.interfaces;

import com.backAP.j.entity.About;

import java.util.List;

public interface IntAboutService {

    public List<About> getListAbout();

    //save About class
    public void saveAbout(About about);

    //delete person
    public void deleteAboutById(Integer id);

    //find person by id
    public About findAboutById(Integer id);
}
