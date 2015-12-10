package web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import web.model.Contato;
import web.model.Telefone;
import web.model.Usuario;
import web.repository.ContatoRepository;
import web.repository.TelefoneRepository;

@ManagedBean
public class ContatosBean {
	@ManagedProperty(value = "#{entityManager}")
	private EntityManager entityManager;

	private Contato contato = new Contato();
	private List<Contato> contatos;
	
	private Telefone telefone;
	private List<Telefone> telefones = new ArrayList<Telefone>();
	private Usuario usuario = new Usuario();

	private String numeroTelefone;
		
	public ContatosBean(){
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(false);
		this.usuario = (Usuario) sessao.getAttribute("usuario");
	}
	public String adiciona() {
	
		this.contato.setUsuario(usuario);
		
		this.contato.setTelefoneContato(telefones);
		
		ContatoRepository repository = new ContatoRepository(this.entityManager);
		repository.adiciona(this.contato);

		this.contato = new Contato();
		this.contato = null;

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Sucesso: ", "Contato Cadastrado Com Sucesso!");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return "cadastro-contato";

	}
	
	public void altera(){
		
		this.contato.setTelefoneContato(telefones);
		
		ContatoRepository repository = new ContatoRepository(this.entityManager);
		repository.update(this.contato);
		
		this.contato = new Contato();
		this.contato = null;
	}

	public void remove(Contato contato) {
		ContatoRepository repository = new ContatoRepository(this.entityManager);
		repository.remove(contato);
		this.contato = null;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato Contato) {
		this.contato = Contato;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
		telefone = new Telefone();
		telefone.setNumeroTelefone(numeroTelefone);
		TelefoneRepository repository = new TelefoneRepository(
				this.entityManager);	
		repository.adiciona(telefone);
		telefones.add(telefone);
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Contato> getContatos() {	
		if (this.contatos == null) {
			System.out.println("CHAMANDO O REPOSITORIO");
			ContatoRepository repository = new ContatoRepository(
					this.entityManager);
			this.contatos = repository.getContatos(usuario.getIdUsuario());
		}
		return this.contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}
