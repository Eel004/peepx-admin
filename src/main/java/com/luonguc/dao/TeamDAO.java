package com.luonguc.dao;

import java.util.List;

import com.luonguc.dto.Player;
import com.luonguc.dto.Team;

public interface TeamDAO {
	public List<Team> getAllTeam();
	public Team getTeamById(int teamId);
}
