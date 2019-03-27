package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.db.model.Alien;


public class AlienDao {
	SessionFactory sf;
	
	public AlienDao() {
		//Configuration cfg = new Configuration().configure().addAnnotatedClass(Alien.class);
		Configuration cfg = new Configuration().configure();
		sf = cfg.buildSessionFactory();
	}
	
	public void createAlien(com.model.Alien a) {
		Session session = sf.openSession();
		Alien dbAlien = new Alien();
		dbAlien.setId(a.getId());
		dbAlien.setName(a.getName());
		dbAlien.setColor(a.getColor());
		Transaction tx = session.beginTransaction();
		session.save(dbAlien);
		tx.commit();
	}

	public com.model.Alien getAlien(int id) {
		Session session = sf.openSession();
		Alien alien = (Alien)session.get(Alien.class, id);
		com.model.Alien a = new com.model.Alien(alien.getId(), alien.getName());
		a.setColor(alien.getColor());
		return a;
	}

}
