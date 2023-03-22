package com.backAP.j.controller;

import com.backAP.j.entity.Project;
import com.backAP.j.interfaces.IntProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PutExchange;

import java.util.Date;
import java.util.List;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    public IntProjectService intProjectService;

    @GetMapping("/get")
    public List<Project> getListProject(){
        List<Project> prjList = intProjectService.getListProject();
        return prjList;
    }

    @PostMapping("/save")
    public String saveProject(@RequestBody Project project){
        intProjectService.saveProject(project);
        return "project data saved succesfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProjectById(@PathVariable Integer id){
        intProjectService.deleteProjectById(id);
        return "project data deleted succesfully";
    }

    @GetMapping("/getProject/{id}")
    public Project getProjectById(Integer id){
        Project prj = intProjectService.findProjectById(id);
        return prj;
    }

    //http://localhost:8080/education/edit/1? PARA PEDIR CON ID 1
    @PutExchange("/edit/{id}")
    public Project editProjectById(@PathVariable Integer id,
                                   @RequestParam("nameProject") String newNameProject,
                                   @RequestParam("descriptionProject") String newDescriptionProject,
                                   @RequestParam("linkProject") String newLinkProject,
                                   @RequestParam("startActivityDate") Date newStartActivityDate,
                                   @RequestParam("endActivityDate") Date newEndActivityDate,
                                   @RequestParam("imagesProject") List<String> newImagesProject){
        Project editPrj = intProjectService.findProjectById(id);

        editPrj.setNameProject(newNameProject);
        editPrj.setDescriptionProject(newDescriptionProject);
        editPrj.setLinkProject(newLinkProject);
        editPrj.setStartActivityDate(newStartActivityDate);
        editPrj.setEndActivityDate(newEndActivityDate);
        editPrj.setImagesProject(newImagesProject);

        intProjectService.saveProject(editPrj);
        return editPrj;
    }
}
