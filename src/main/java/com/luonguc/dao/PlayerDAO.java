package com.luonguc.dao;

import java.util.List;

import com.luonguc.dto.Player;

public interface PlayerDAO {
	public void addPlayer(Player emp);
	Player getPlayerByID(int empID);
	public List<Player> getAllPlayer();
	public boolean updatePlayer(int emp_id,Player e);
	public boolean deletePlayer(int empId);
}
