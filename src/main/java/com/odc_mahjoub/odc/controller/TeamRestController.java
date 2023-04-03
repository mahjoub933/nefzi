package com.odc_mahjoub.odc.controller;

import com.odc_mahjoub.odc.entity.Team;
import com.odc_mahjoub.odc.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamRestController {
@Autowired
    private TeamService teamService;
@GetMapping("/all")
public ResponseEntity<List<Team>> getAllTeam(){
     List<Team> teams = teamService.findAllTeam();
     return new ResponseEntity<>(teams, HttpStatus.OK);
 }
 @PostMapping("/add")
 public ResponseEntity  saveTeam(@RequestBody Team team){
    Team insertTeam= teamService.createTeam(team);
    if(insertTeam == null){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity(insertTeam.getId(),HttpStatus.ACCEPTED);
 }
 @PostMapping("/update")
    public ResponseEntity  modifyTeam (@RequestBody Team team){
        teamService.updateTeam(team);
            return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity  delTeam (@PathVariable("id") Long id){
        teamService.deleteTeam(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
