package web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import web.model.Telefone;

public class TelefoneRepository {
	private EntityManager entityManager;

	public TelefoneRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Telefone telefone) {
		entityManager.persist(telefone);
		entityManager.flush();
	}

	public void remove(Telefone telefone) {
		entityManager.remove(telefone);
		entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Telefone> getTelefones() {
		Query query = this.entityManager
				.createQuery("select t from Telefone as t");
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void update(Telefone telefone) {
		entityManager.merge(telefone);
		entityManager.flush();
		
	}

}
		
			
	

