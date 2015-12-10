package web.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import web.model.Usuario;

public class UsuarioRepository {
	private EntityManager entityManager;

	public UsuarioRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void adiciona(Usuario usuario) {
		entityManager.persist(usuario);
		entityManager.flush();
	}

	public void remove(Usuario usuario) {
		entityManager.remove(usuario);
		entityManager.flush();
	}

	public Usuario procura(String emailUsuario, String senhaUsuario)
			throws NoResultException {
		Query query = this.entityManager
				.createQuery("select u from Usuario as u where u.emailUsuario='"
						+ emailUsuario
						+ "' and u.senhaUsuario='"
						+ senhaUsuario + "'");
		

		return (Usuario) query.getSingleResult();

	}
	
	public Usuario procuraEmail(String emailUsuario)
			throws NoResultException {
		Query query = this.entityManager
				.createQuery("select u from Usuario as u where u.emailUsuario='"
						+ emailUsuario
						+ "'");

		return (Usuario) query.getSingleResult();

	}
	
	public Usuario procuraId(Long id) throws NoResultException{
		Query query = this.entityManager.createQuery("select p from Usuario p join fetch p.telefoneUsuario where p.idUsuario = :id");
		query.setParameter("id", id);
		
		return (Usuario) query.getSingleResult();

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> getusuarios() {
		Query query = this.entityManager
				.createQuery("select u from Usuario as u");
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void update(Usuario usuario) {
		entityManager.merge(usuario);
		entityManager.flush();
		
	}

}
