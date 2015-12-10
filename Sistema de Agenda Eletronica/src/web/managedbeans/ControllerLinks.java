package web.managedbeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ControllerLinks {
	
	public String irParaCadastro(){
		return "/cadastro-usuario";
	}
	
	public String irParaLogin(){
		return "/login";
	}
	
	public String irParaAlteracaoUsuario(){
		return "/altera-usuario";
	}
	
	public String irParaAlteracaoSenha(){
		return "/altera-senha-usuario";
	}
	
	public String irParaMinhaConta(){
		return "/minha-conta";
	}
	
	
}
