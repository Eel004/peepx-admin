package com.luonguc.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.luonguc.dto.Position;
import com.luonguc.dto.Team;
import com.luonguc.service.PositionService;

@Component
public class PositionConverter implements Converter<String, Position> {

	@Autowired private PositionService positionService;
	@Override
	public Position convert(String id) {
		return positionService.getPositionById(Integer.parseInt(id));
	}

}
