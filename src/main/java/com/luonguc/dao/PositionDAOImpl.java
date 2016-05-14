package com.luonguc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luonguc.dto.Position;
import com.luonguc.dto.Team;

@Repository
public class PositionDAOImpl implements PositionDAO {

	@Autowired private SessionFactory sessionFactory;
	@Override
	public Position getPositionById(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Position position = (Position) session.get(Team.class, id);
		tx.commit();
		return position;
	}
	
	@Override
	public List<Position> getAllPosition() {
		List<Position> positionList = new ArrayList<Position>();
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			positionList = session.createQuery("FROM Position").list();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				System.err.println("process transaction fail beacause: " + ex);
			}
		} finally {
			session.close();
		}
		return positionList;
	}

}
