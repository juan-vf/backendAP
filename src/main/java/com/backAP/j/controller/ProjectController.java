package com.backAP.j.controller;

import com.backAP.j.Dto.DtoProject;
import com.backAP.j.entity.Project;
import com.backAP.j.interfaces.IntProjectService;
import com.backAP.j.security.entity.Mensaje;
import com.backAP.j.service.ImpProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.Date;
import java.util.List;

@RestController
@Controller
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = {"http://localhost:4200", "https://frontendap-90374.web.app"})
@RequestMapping("/project")
public class ProjectController {
    //@Autowired
    //public IntProjectService intProjectService;
    @Autowired
    public ImpProjectService impProjectService;

    @GetMapping("/get")
    public ResponseEntity<List<Project>> getListProject(){
        List<Project> prjList = impProjectService.getListProject();
        return new ResponseEntity(prjList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveProject(@RequestBody DtoProject dtoProject){

        if(StringUtils.isBlank(dtoProject.getNameProject())){
            return new ResponseEntity(new Mensaje("the name is required"), HttpStatus.BAD_REQUEST);
        }
        if( impProjectService.existByNameProject(dtoProject.getNameProject())){
            return new ResponseEntity(new Mensaje("that name experience already exist"), HttpStatus.BAD_REQUEST);
        }
        Project project = new Project(dtoProject.getNameProject(),
                dtoProject.getDescriptionProject(),
                dtoProject.getLinkProject(),
                dtoProject.getStartActivityDate(), dtoProject.getEndActivityDate(),
                dtoProject.getImagesProject());
        impProjectService.saveProject(project);
        return new ResponseEntity(new Mensaje("Education data saved succesfully"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProjectById(@PathVariable("id") int id){
        if(!impProjectService.existsById(id)){
            new ResponseEntity(new Mensaje("Education id not exist"), HttpStatus.BAD_REQUEST) ;
        }

        impProjectService.deleteProjectById(id);
        return new ResponseEntity(new Mensaje("deleted experience"), HttpStatus.OK);
    }

    @GetMapping("/getProject/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") int id){

        if(!impProjectService.existsById(id)){
            new ResponseEntity(new Mensaje("Education id not exist"), HttpStatus.BAD_REQUEST);
        }
        Project prj = impProjectService.findProjectById(id).get();
        return new ResponseEntity<>(prj, HttpStatus.OK);
    }

    //http://localhost:8080/education/edit/1? PARA PEDIR CON ID 1
    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editProjectById(@PathVariable("id") int id,
                                   @RequestBody DtoProject dtoProject){

        if(!impProjectService.existsById(id)){
            new ResponseEntity(new Mensaje("Education id not exist"), HttpStatus.BAD_REQUEST);
        }

        if(impProjectService.existByNameProject(dtoProject.getNameProject()) && impProjectService.getByNameProject(dtoProject.getNameProject()).get().getId() != id){
            new ResponseEntity(new Mensaje("Education already exist"), HttpStatus.BAD_REQUEST) ;
        }

        if(StringUtils.isBlank(dtoProject.getNameProject())){
            new ResponseEntity(new Mensaje("Education name is required"), HttpStatus.BAD_REQUEST) ;
        }
        Project editPrj = impProjectService.findProjectById(id).get();

        editPrj.setNameProject(dtoProject.getNameProject());
        editPrj.setDescriptionProject(dtoProject.getDescriptionProject());
        editPrj.setLinkProject(dtoProject.getLinkProject());
        editPrj.setStartActivityDate(dtoProject.getStartActivityDate());
        editPrj.setEndActivityDate(dtoProject.getEndActivityDate());
        editPrj.setImagesProject(dtoProject.getImagesProject());

        impProjectService.saveProject(editPrj);
        return new ResponseEntity(new Mensaje("updated and saved education"), HttpStatus.OK) ;
    }
}
