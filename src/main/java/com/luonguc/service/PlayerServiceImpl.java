package com.luonguc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luonguc.dao.PlayerDAO;
import com.luonguc.dto.Player;

@Service
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	private PlayerDAO emplyeeDAO;
	
	@Override
	@Transactional
	public void addPlayer(Player emp) {
		emplyeeDAO.addPlayer(emp);
	}
	
	@Override
	@Transactional
	public Player getPlayerByID(int empID) {
		return emplyeeDAO.getPlayerByID(empID);
	}

	@Override
	@Transactional
	public List<Player> getAllPlayer() {
		return emplyeeDAO.getAllPlayer();
	}

	@Override
	@Transactional
	public boolean update(int empId, Player e) {
		return emplyeeDAO.updatePlayer(empId, e);
	}

	@Override
	@Transactional
	public boolean deletePlayer(int empId) {
		return emplyeeDAO.deletePlayer(empId);
	}
}
