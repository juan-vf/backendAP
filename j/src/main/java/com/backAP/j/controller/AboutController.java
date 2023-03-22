package com.backAP.j.controller;

import com.backAP.j.entity.About;
import com.backAP.j.interfaces.IntAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Controller
@RequestMapping("/about")
@CrossOrigin(origins = "http://localhost:4200")
public class AboutController {
    @Autowired
    private IntAboutService intAboutService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/get")
    public List<About> getListAbout(){
        List<About> aboutList = intAboutService.getListAbout();
        return aboutList;
    }

    @PostMapping("/save")
    public String saveAbout(@RequestBody About about){
        intAboutService.saveAbout(about);
        return "About data saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteAboutById(@PathVariable Integer id){
        intAboutService.deleteAboutById(id);
        return "About data deleted succesfully";
    }

    @PutMapping("/edit/{id}")
    public String editAboutById(@PathVariable Integer id,
                                @RequestParam("tittleAbout") String newTittleAbout,
                                @RequestParam("descriptionAbout") String newDescriptionAbout){
        About editedAbout = intAboutService.findAboutById(id);
        editedAbout.setTittleAbout(newTittleAbout);
        editedAbout.setDescriptionAbout(newDescriptionAbout);

        intAboutService.saveAbout(editedAbout);
        return "About data edited succesfully";
    }

    @GetMapping("/getabout/{id}")
    public About getAboutById(Integer id){
        About about = intAboutService.findAboutById(id);
        return about;
    }
}
