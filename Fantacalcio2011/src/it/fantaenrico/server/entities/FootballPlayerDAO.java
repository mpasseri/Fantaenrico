package it.fantaenrico.server.entities;

import it.fantaenrico.client.entities.FootballPlayer;
import it.fantaenrico.client.entities.FootballTeam;
import it.fantaenrico.server.persistence.EMF;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class FootballPlayerDAO {

	String footballPlayerClassName = "it.fantaenrico.client.entities.FootballPlayer";

	public FootballPlayerDAO() {
	}

	public void insert(FootballPlayer player) {
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(player);
			em.getTransaction().commit();
		}
		finally {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}

	public void insert(List<FootballPlayer> players) {
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		try {
			for(FootballPlayer player : players)
				em.persist(player);
			em.getTransaction().commit();
		}
		finally {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}

	public void delete(FootballPlayer player) {
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(player);
			em.getTransaction().commit();
		}
		finally {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}

	public void delete(List<FootballPlayer> players) {
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		try {
			for(FootballPlayer player : players)
				em.remove(player);
			em.getTransaction().commit();
		}
		finally {
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<FootballPlayer> retrieveAll() {

		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		try {
			String qString = "Select fp from "+footballPlayerClassName+ " fp";

			Query q = em.createQuery(qString);

			return q.getResultList();
		}
		finally {
			em.getTransaction().rollback();
			em.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<FootballPlayer> retrieveByTeam(FootballTeam team) {

		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		try {
			String qString = "Select fp from "+footballPlayerClassName+" fp " +
			"where fp.team = :team";

			Query q = em.createQuery(qString);
			q.setParameter("team", team);

			return q.getResultList();
		}
		finally {
			em.getTransaction().rollback();
			em.close();
		}

	}

}
