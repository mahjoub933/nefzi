package com.odc_mahjoub.odc.controller;

import com.odc_mahjoub.odc.entity.Team;
import com.odc_mahjoub.odc.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class TeamController {
@Autowired
    private TeamService teamService;
@GetMapping("/")
    public String getAllTeam(Model model){
        List<Team> teams = teamService.findAllTeam();
        model.addAttribute("teams",teams);
      return "index";

    }
    @RequestMapping("/addTeam")
    public String addNewTeam(Team team){
        Team result =teamService.createTeam(team);
        if (result == null) {
            return "redirect:/";
        }
        return "redirect:/";
    }
    @RequestMapping({"/edit","/edit/{id}"})
    public String upTeam(Model model, @PathVariable("id")Optional<Long> id){

    if(id.isPresent()){
        Optional<Team> team = teamService.findStudentByid(id.get());
        if(team.isPresent()){
            model.addAttribute("team", team);
        } else{
            model.addAttribute("team", new Team());
        }
    }
       return "add-edit-Team";
    }
    @RequestMapping("/delete/{id}")
    public String delTEAM(@PathVariable("id") Long id){
    teamService.deleteTeam(id);
    return "redirect:/";
    }
}
