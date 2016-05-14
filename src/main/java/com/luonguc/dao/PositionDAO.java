package com.luonguc.dao;

import java.util.List;

import com.luonguc.dto.Position;

public interface PositionDAO {
	public Position getPositionById(int id);
	public List<Position> getAllPosition();
}
