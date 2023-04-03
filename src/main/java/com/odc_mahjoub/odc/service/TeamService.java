package com.odc_mahjoub.odc.service;

import com.odc_mahjoub.odc.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

List <Team> findAllTeam();

Team createTeam (Team team);

void updateTeam (Team team);

void deleteTeam (Long id);

Optional <Team> findStudentByid(Long id);
}
