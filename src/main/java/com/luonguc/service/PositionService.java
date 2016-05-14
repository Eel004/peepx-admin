package com.luonguc.service;

import java.util.List;

import com.luonguc.dto.Position;

public interface PositionService {
	public Position getPositionById(int id);
	public List<Position> getAllPosition();
}
