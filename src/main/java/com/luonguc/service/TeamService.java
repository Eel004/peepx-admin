package com.luonguc.service;

import java.util.List;

import com.luonguc.dto.Player;
import com.luonguc.dto.Team;

public interface TeamService {
	public List<Team> getAllTeam();
	public Team getTeamById(int teamId);
}
