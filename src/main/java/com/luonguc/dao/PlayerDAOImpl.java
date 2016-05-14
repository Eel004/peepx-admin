package com.luonguc.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luonguc.dto.Player;
import com.luonguc.dto.Team;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addPlayer(Player player) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(player);
		tx.commit();
	}

	@Override
	public Player getPlayerByID(int playerID) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Player player = (Player) session.get(Player.class, playerID);
		tx.commit();
		return player;
	}

	@Override
	public List<Player> getAllPlayer() {
		List<Player> rs = null;
		Session session = null;
		Transaction tx = null;
		// sessionFactory = new
		// Configuration().configure().buildSessionFactory();
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			rs = session.createQuery("FROM Player").list();
			tx.commit();
		} catch (HibernateException ex) {
			if (tx != null) {
				tx.rollback();
				System.err.println("process transaction fail beacause: " + ex);
			}
		} finally {
			session.close();
		}
		return rs;
	}

	@Override
	public boolean updatePlayer(int playerId, Player e) {
		Session session = sessionFactory.openSession();
		Transaction tx  = session.beginTransaction();
		String strQuery = "UPDATE Player set playerId = '" + e.getPlayerId()
				+ "', firstName = '" + e.getFirstName() + "', lastName = '" + e.getLastName()
				+ "', position = '" + e.getPosition() + "', address = '"
				+ e.getAddress() + "', phoneNo = '" + e.getPhoneNo()
				+ "', email = '" + e.getEmail() + "', birthDate = '"
				+ e.getBirthDate() + "' WHERE playerId = " + e.getPlayerId();
		Query query = session.createQuery(strQuery);
		int result = query.executeUpdate();
		tx.commit();
		session.close();
		return result > 0;
	}

	@Override
	public boolean deletePlayer(int playerId) {
		Session session = sessionFactory.openSession();
		String hql  = "DELETE FROM Player WHERE playerId =" + playerId;
		Query query = session.createQuery(hql);
		int rs = query.executeUpdate();
		return rs > 0;
	}
}




