package web.managedbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import web.model.Telefone;
import web.model.Usuario;
import web.repository.UsuarioRepository;
import web.util.Validacoes;

@ManagedBean
public class MinhaContaBean {
	@ManagedProperty(value = "#{entityManager}")
	private EntityManager entityManager;
	private Usuario usuario = new Usuario();
	private List <Telefone> telefones;
	private String senha;
	private String email;
	
	
	public MinhaContaBean() throws InterruptedException{
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(false);
		usuario = (Usuario) sessao.getAttribute("usuario");
	
	}
	

	public void alterarSenha(){
		if (Validacoes.validarSenha(this.senha, this.usuario)){
			UsuarioRepository repository = new UsuarioRepository(
					this.entityManager);
			repository.update(this.usuario);
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Sucesso: ", "Senha Alterada Com Sucesso!");

			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	
	public String alterarUsuario(){
		UsuarioRepository repository = new UsuarioRepository(
				this.entityManager);
		repository.update(this.usuario);
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Sucesso: ", "Informações Atualizadas Com Sucesso!");

		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return "/minha-conta";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public List<Telefone> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	
	

}
