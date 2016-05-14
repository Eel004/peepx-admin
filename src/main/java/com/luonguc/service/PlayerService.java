package com.luonguc.service;

import java.util.List;

import com.luonguc.dto.Player;

public interface PlayerService {
	public void addPlayer(Player player);
	public Player getPlayerByID(int playerID);
	public List<Player> getAllPlayer();
	public boolean update(int playerId, Player e);
	public boolean deletePlayer(int playerId);
}
