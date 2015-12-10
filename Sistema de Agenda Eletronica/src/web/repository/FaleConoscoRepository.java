package web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import web.model.FaleConosco;

public class FaleConoscoRepository {
	private EntityManager entityManager;

	public FaleConoscoRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(FaleConosco faleConosco) {
		entityManager.persist(faleConosco);
		entityManager.flush();
	}

	public void remove(FaleConosco faleConosco) {
		entityManager.remove(faleConosco);
		entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<FaleConosco> getFaleConosco() {
		Query query = this.entityManager
				.createQuery("select f from FaleConosco as f");
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
