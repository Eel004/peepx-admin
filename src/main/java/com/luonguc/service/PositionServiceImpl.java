package com.luonguc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luonguc.dao.PositionDAO;
import com.luonguc.dto.Position;
@Service
public class PositionServiceImpl implements PositionService {
	
	@Autowired private PositionDAO positionDAO;
	@Override
	@Transactional
	public Position getPositionById(int id) {
		return positionDAO.getPositionById(id);
	}
	@Override
	@Transactional
	public List<Position> getAllPosition() {
		return positionDAO.getAllPosition();
	}
	
}
