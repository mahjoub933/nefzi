package com.odc_mahjoub.odc.service.impl;

import com.odc_mahjoub.odc.entity.Team;
import com.odc_mahjoub.odc.repository.TeamRepository;
import com.odc_mahjoub.odc.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TeamServiceImpl implements TeamService {
@Autowired
    private TeamRepository teamRepository;
    @Override
    public List<Team> findAllTeam() {
        return teamRepository.findAll();
    }

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public void updateTeam(Team team) {
           teamRepository.save(team);
    }

    @Override
    public void deleteTeam(Long id) {
          teamRepository.deleteById(id);
    }

    @Override
    public Optional<Team> findStudentByid(Long id) {
        return teamRepository.findById(id);
    }
}
