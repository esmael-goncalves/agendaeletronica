package web.managedbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import web.model.Compromisso;
import web.model.Usuario;
import web.repository.CompromissoRepository;

@ManagedBean
public class CompromissosBean {

	private Compromisso compromisso = new Compromisso();
	private List<Compromisso> compromissoList;

	private Usuario usuario = new Usuario();

	@ManagedProperty(value = "#{entityManager}")
	private EntityManager entityManager;

	public CompromissosBean() {

		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(false);
		this.usuario = (Usuario) sessao.getAttribute("usuario");
	}

	public String adiciona() {
		try {
			this.compromisso.setUsuario(usuario);
			CompromissoRepository repository = new CompromissoRepository(
					this.entityManager);
			repository.adiciona(this.compromisso);

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso: ", "Compromisso Cadastrado Com Sucesso!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "compromisso-cadastrado";
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro: ",
					"Não Foi Possível Realizar o Cadastro do Compromisso!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return null;
		}
	}

	public void altera() {

		CompromissoRepository repository = new CompromissoRepository(
				this.entityManager);
		repository.update(this.compromisso);

		this.compromisso = new Compromisso();
		this.compromisso = null;
	}

	public void remove(Compromisso compromisso) {
		CompromissoRepository repository = new CompromissoRepository(
				this.entityManager);
		repository.remove(compromisso);
		this.compromisso = null;
	}

	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	public List<Compromisso> getCompromissoList() {
		if (this.compromissoList == null) {
			System.out.println("CHAMANDO O REPOSITORIO");
			CompromissoRepository repository = new CompromissoRepository(
					this.entityManager);
			this.compromissoList = repository.getCompromissos(usuario
					.getIdUsuario());
		}
		return compromissoList;
	}

	public void setCompromissoList(List<Compromisso> compromissoList) {
		this.compromissoList = compromissoList;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Compromisso getUltimoCompromisso() {
		if (this.compromissoList == null) {
			System.out.println("CHAMANDO O REPOSITORIO");
			CompromissoRepository repository = new CompromissoRepository(
					this.entityManager);
			this.compromissoList = repository.getCompromissos(usuario
					.getIdUsuario());
		}

		int num = compromissoList.size();

		return compromissoList.get(num - 1);
	}

}
