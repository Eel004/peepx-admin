package com.luonguc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luonguc.dao.TeamDAO;
import com.luonguc.dto.Team;

@Service
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamDAO teamDAO;
	
	@Override
	@Transactional
	public List<Team> getAllTeam() {
		return teamDAO.getAllTeam();
	}

	@Override
	@Transactional
	public Team getTeamById(int teamId) {
		return teamDAO.getTeamById(teamId);
	}
}
