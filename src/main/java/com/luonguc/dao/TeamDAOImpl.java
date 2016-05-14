package com.luonguc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luonguc.dto.Player;
import com.luonguc.dto.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Team> getAllTeam() {
		List<Team> teamList = new ArrayList<Team>();
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			teamList = session.createQuery("From Team").list();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				System.err.println("process transaction fail beacause: " + ex);
			}
		} finally {
			session.close();
		}
		return teamList;
	}

	@Override
	public Team getTeamById(int teamId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Team team = (Team) session.get(Team.class, teamId);
		tx.commit();
		return team;
	}
}
