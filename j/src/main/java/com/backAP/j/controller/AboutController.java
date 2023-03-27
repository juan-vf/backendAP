package com.backAP.j.controller;

import com.backAP.j.Dto.DtoAbout;
import com.backAP.j.entity.About;
import com.backAP.j.interfaces.IntAboutService;
import com.backAP.j.security.entity.Mensaje;
import com.backAP.j.service.ImpAboutService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Controller
@RequestMapping("/about")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendap-90374.web.app"})
public class AboutController {
    //@Autowired
    //private IntAboutService intAboutService;
    @Autowired
    public ImpAboutService impAboutService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getList")
    public ResponseEntity<List<About>> getListAbout(){
        List<About> aboutList = impAboutService.getListAbout();
        return new ResponseEntity(aboutList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveAbout(@RequestBody DtoAbout dtoAbout){
        if(StringUtils.isBlank(dtoAbout.getTittleAbout())){
            return new ResponseEntity(new Mensaje("the name is required"), HttpStatus.BAD_REQUEST);
        }
        if( impAboutService.existByTittleAbout(dtoAbout.getTittleAbout())){
            return new ResponseEntity(new Mensaje("that name about already exist"), HttpStatus.BAD_REQUEST);
        }
        About about = new About(dtoAbout.getTittleAbout(), dtoAbout.getDescriptionAbout());
        impAboutService.saveAbout(about);
        return new ResponseEntity(new Mensaje("ABOUT data saved succesfully"), HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAboutById(@PathVariable("id") int id){
        if(!impAboutService.existsById(id)){
            new ResponseEntity(new Mensaje("About id not exist"), HttpStatus.BAD_REQUEST);
        }

        impAboutService.deleteAboutById(id);
        return new ResponseEntity(new Mensaje("deleted about"), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editAboutById(@PathVariable Integer id,
                                @RequestBody DtoAbout dtoAbout){

        if(!impAboutService.existsById(id)){
            new ResponseEntity(new Mensaje("about id not exist"), HttpStatus.BAD_REQUEST);
        }

        if(impAboutService.existByTittleAbout(dtoAbout.getTittleAbout()) && impAboutService.getByTittleAbout(dtoAbout.getTittleAbout()).get().getId() != id){
            new ResponseEntity(new Mensaje("about already exist"), HttpStatus.BAD_REQUEST) ;
        }

        if(StringUtils.isBlank(dtoAbout.getTittleAbout())){
            new ResponseEntity(new Mensaje("about name is required"), HttpStatus.BAD_REQUEST) ;
        }
        About editedAbout = impAboutService.findAboutById(id).get();
        editedAbout.setTittleAbout(dtoAbout.getTittleAbout());
        editedAbout.setDescriptionAbout(dtoAbout.getDescriptionAbout());

        impAboutService.saveAbout(editedAbout);
        return new ResponseEntity(new Mensaje("updated and saved About"), HttpStatus.OK) ;
    }

    @GetMapping("/getabout/{id}")
    public ResponseEntity<About> getAboutById(@PathVariable("id") int id){
        if(!impAboutService.existsById(id)){
            new ResponseEntity(new Mensaje("About id not exist"), HttpStatus.BAD_REQUEST);
        }
        About about = impAboutService.findAboutById(id).get();
        return new ResponseEntity(about, HttpStatus.OK);
    }
}
