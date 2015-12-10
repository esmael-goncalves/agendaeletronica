package web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.apache.commons.mail.EmailException;

import web.model.Telefone;
import web.model.Usuario;
import web.repository.TelefoneRepository;
import web.repository.UsuarioRepository;
import web.util.EmailService;
import web.util.Validacoes;

@ManagedBean
public class UsuarioBean {
	@ManagedProperty(value = "#{entityManager}")
	private EntityManager entityManager;

	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	private Telefone telefone;
	private List<Telefone> telefones = new ArrayList<Telefone>();

	private String numeroTelefone;

	private String email;
	private String senha;

	@SuppressWarnings("finally")
	public String adiciona() {
		if (Validacoes.validarEmail(this.email, this.usuario)) {
			if (Validacoes.validarSenha(this.senha, this.usuario)) {

				if (!Validacoes.emailExiste(this.email, this.usuario,
						this.entityManager)) {
					
					this.usuario.setTelefoneUsuario(telefones);
					
					UsuarioRepository repository = new UsuarioRepository(
							this.entityManager);
					repository.adiciona(this.usuario);

					try {
						EmailService.sendMailCadastro(EmailService
								.emailCadastro(usuario.getNomeUsuario()),
								usuario.getEmailUsuario());
					} catch (EmailException e) {
						FacesMessage msg = new FacesMessage(
								FacesMessage.SEVERITY_WARN, "Atenção :",
								"Problemas ao enviar o e-mail de confirmação");

						FacesContext.getCurrentInstance().addMessage(null, msg);
					}

					finally {
						this.usuario = new Usuario();
						this.usuario = null;

						FacesMessage msg = new FacesMessage(
								FacesMessage.SEVERITY_INFO, "Sucesso: ",
								"Usuário Cadastrado Com Sucesso!");

						FacesContext.getCurrentInstance().addMessage(null, msg);

						return "cadastro-realizado";
					}
				}

			}
		}

		return "";
	}

	public void remove(Usuario usuario) {
		UsuarioRepository repository = new UsuarioRepository(this.entityManager);
		repository.remove(usuario);
		this.usuario = null;
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

	public List<Usuario> getUsuarios() {
		if (this.usuarios == null) {
			System.out.println("CHAMANDO O REPOSITORIO");
			UsuarioRepository repository = new UsuarioRepository(
					this.entityManager);
			this.usuarios = repository.getusuarios();
		}
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUltimoUsuario() {
		if (this.usuarios == null) {
			System.out.println("CHAMANDO O REPOSITORIO");
			UsuarioRepository repository = new UsuarioRepository(
					this.entityManager);
			this.usuarios = repository.getusuarios();
		}

		int num = usuarios.size();

		return usuarios.get(num - 1);
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
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

}
