package web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import web.model.Contato;

public class ContatoRepository {
	private EntityManager entityManager;

	public ContatoRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Contato contato) {
		entityManager.persist(contato);
		entityManager.flush();
	}

	public void remove(Contato contato) {
		entityManager.remove(contato);
		entityManager.flush();
	}

	/*public Contato procura(Long idContato)
			throws NoResultException {
		Query query = this.entityManager
				.createQuery("select c from Contato as c where c.idContato='"
						+ idContato+"'");

		return (Contato) query.getSingleResult();

	}*/
	
	public Contato procuraId(Long id) throws NoResultException{
		Query query = this.entityManager.createQuery("select c from Contato c join fetch c.telefoneContato where c.idContato = :id");
		query.setParameter("id", id);
		
		return (Contato) query.getSingleResult();

	}
	
	/*public Contato procuraEmail(String emailContato)
			throws NoResultException {
		Query query = this.entityManager
				.createQuery("select u from Usuario as u where u.emailUsuario='"
						+ emailContato
						+ "'");

		return (Contato) query.getSingleResult();

	}*/

	@SuppressWarnings("unchecked")
	public List<Contato> getContatos(Long id) {
		Query query = this.entityManager
				.createQuery("select c from Contato as c where usuario_idUsuario= :id");
		query.setParameter("id", id);
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void update(Contato contato) {
		entityManager.merge(contato);
		entityManager.flush();
		
	}
}
