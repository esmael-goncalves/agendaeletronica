package web.util;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import web.model.Usuario;

public class FaseListener implements PhaseListener {

	private String[] paginasAutorizadas = new String[] { "/indexout.xhtml",
			"/sobre-empresa.xhtml", "/sobre-agenda-eletronica.xhtml",
			"/cadastro-usuario.xhtml", "/cadastro-realizado.xhtml",
			"/faleconosco.xhtml", "/login.xhtml" };

	private static final long serialVersionUID = 1L;

	public boolean verificaAutorizacao(String url) {

		for (String pagina : paginasAutorizadas) {
			if (url.equals(pagina)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void afterPhase(PhaseEvent event) {

		// Obtém o contexto atual
		FacesContext contexto = event.getFacesContext();
		// Obtém a página que atualmente está interagindo com o ciclo
		String paginaAtual = contexto.getViewRoot().getViewId();
		// Se for a página 'login.jsp' seta a variável como true
		boolean isLoginPage = paginaAtual.lastIndexOf("login.xhtml") > -1;
		
		// Obtém a sessão atual
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(true);
		// Restaga o nome do usuário logado
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		// Verifica se o usuário está logado e se não está na página de login
		if (!isLoginPage && (!paginaAtual.equals("/indexout.xhtml"))&& (!paginaAtual.equals("/sobre-empresa.xhtml"))
				&& (!paginaAtual.equals("/sobre-agenda-eletronica.xhtml")) && (!paginaAtual.equals("/cadastro-usuario.xhtml"))
				&& (!paginaAtual.equals("/cadastro-realizado.xhtml")) && (!paginaAtual.equals("/faleconosco.xhtml"))
				&& usuario == null) {
			// Redireciona o fluxo para a página de login
			NavigationHandler nh = contexto.getApplication()
					.getNavigationHandler();
			nh.handleNavigation(contexto, null, "sair");
		} else if (isLoginPage && usuario != null) {
			// Se o usuário logado tentar acessar a página de login ele é
			// redirecionado para a página inicial
			NavigationHandler nh = contexto.getApplication()
					.getNavigationHandler();
			nh.handleNavigation(contexto, null, "sucesso");
		}

		

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
		 System.out.println("PRINT DE IDENTIFICAÇÃO DO EVENTO before: " +
		 event.getPhaseId());
		 
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
