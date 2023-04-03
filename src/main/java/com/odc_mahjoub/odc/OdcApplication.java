package com.odc_mahjoub.odc;
import com.odc_mahjoub.odc.entity.Team;
import com.odc_mahjoub.odc.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class OdcApplication implements CommandLineRunner {
@Autowired
	TeamService teamService;
	public static void main(String[] args) {
		SpringApplication.run(OdcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Team> teams = teamService.findAllTeam();


			Team team2 = Team.builder().name("RIHAB").description("A7LA RIHAB").result(100.0).build();
			Team team3 = Team.builder().name("RIHAB").description("A7LA RIHAB").result(100.0).build();

	}
}
