package web.managedbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import web.model.Telefone;
import web.model.Usuario;
import web.repository.UsuarioRepository;

@ManagedBean
public class LoginBean {
	@ManagedProperty(value = "#{entityManager}")
	private EntityManager entityManager;
	private String email;
	private String senha;
	private Usuario usuario = new Usuario();
	private List<Telefone> telefones;

	// private boolean logado;

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public LoginBean() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(false);

		usuario = (Usuario) sessao.getAttribute("usuario");

	}

	public String logar() {

		try {
			UsuarioRepository repository = new UsuarioRepository(
					this.entityManager);
			usuario = repository.procura(email,senha);
			
			usuario = repository.procuraId(usuario.getIdUsuario());

			FacesContext contexto = FacesContext.getCurrentInstance();
			HttpSession sessao = (HttpSession) contexto.getExternalContext()
					.getSession(false);
			sessao.setAttribute("usuario", usuario);
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Bem Vindo: ", usuario.getNomeUsuario());

			FacesContext.getCurrentInstance().addMessage(null, msg);
			   
			return "sucesso";
		} catch (NoResultException e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Atenção: ", "Usuário ou Senha Inválidos!");

			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "";
		}

	}

	public String sair() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(false);
		sessao.removeAttribute("usuario");
		sessao.invalidate();
		email = null;
		senha = null;
		usuario = null;
		return "sair";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public boolean usuarioExiste(){
		try{
			UsuarioRepository repository = new UsuarioRepository(this.entityManager);
			repository.procura(email,senha);
			
			return true;
			}
			catch(Exception e){
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro:", "Usuário ou Senha Inválidos!");

				FacesContext.getCurrentInstance().addMessage(null, msg);
				return false;
			}
	}

}
