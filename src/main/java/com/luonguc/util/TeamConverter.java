package com.luonguc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.luonguc.dto.Team;
import com.luonguc.service.TeamService;

@Component
public class TeamConverter implements Converter<String, Team>{

	@Autowired private TeamService teamService;
	
	@Override
	public Team convert(String teamId) {
		return teamService.getTeamById(Integer.parseInt(teamId));
	}
	
	
}
