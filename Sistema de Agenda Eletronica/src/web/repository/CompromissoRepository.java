package web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import web.model.Compromisso;

public class CompromissoRepository {
	private EntityManager entityManager;

	public CompromissoRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Compromisso compromisso) {
		entityManager.persist(compromisso);
		entityManager.flush();
	}

	public void remove(Compromisso compromisso) {
		entityManager.remove(compromisso);
		entityManager.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Compromisso> getCompromissos(Long id) {
		Query query = this.entityManager
				.createQuery("select c from Compromisso as c where usuario_idUsuario= :id");
		query.setParameter("id", id);
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void update(Compromisso compromisso) {
		entityManager.merge(compromisso);
		entityManager.flush();
		
	}

}
		
			
	

