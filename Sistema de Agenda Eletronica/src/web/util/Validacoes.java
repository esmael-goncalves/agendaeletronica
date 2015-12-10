package web.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import web.model.Usuario;
import web.repository.UsuarioRepository;

public class Validacoes {
	
	public static boolean validarEmail(String email, Usuario usuario) {
		if (email.equals(usuario.getEmailUsuario())) {
			return true;
		} else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Atenção: ", "Emails Diferentes. Confirme o Email");

			FacesContext.getCurrentInstance().addMessage(null, msg);
			return false;
		}

	}

	public static boolean emailExiste(String email, Usuario usuario, EntityManager entityManager) {
		try {
			UsuarioRepository repository = new UsuarioRepository(
					entityManager);
			repository.procuraEmail(email);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"ERRO: ", "Já Existe Uma Conta Utilizando Este Email.");

			FacesContext.getCurrentInstance().addMessage(null, msg);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean validarSenha(String senha, Usuario usuario) {
		if (senha.equals(usuario.getSenhaUsuario()))
			return true;
		else {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Atenção: ", "Senhas Diferentes. Confirme a Senha.");

			FacesContext.getCurrentInstance().addMessage(null, msg);
			return false;
		}
	}
}
