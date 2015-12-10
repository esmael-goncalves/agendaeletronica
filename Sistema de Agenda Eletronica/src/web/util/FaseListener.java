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

		// Obt�m o contexto atual
		FacesContext contexto = event.getFacesContext();
		// Obt�m a p�gina que atualmente est� interagindo com o ciclo
		String paginaAtual = contexto.getViewRoot().getViewId();
		// Se for a p�gina 'login.jsp' seta a vari�vel como true
		boolean isLoginPage = paginaAtual.lastIndexOf("login.xhtml") > -1;
		
		// Obt�m a sess�o atual
		HttpSession sessao = (HttpSession) contexto.getExternalContext()
				.getSession(true);
		// Restaga o nome do usu�rio logado
		Usuario usuario = (Usuario) sessao.getAttribute("usuario");
		// Verifica se o usu�rio est� logado e se n�o est� na p�gina de login
		if (!isLoginPage && (!paginaAtual.equals("/indexout.xhtml"))&& (!paginaAtual.equals("/sobre-empresa.xhtml"))
				&& (!paginaAtual.equals("/sobre-agenda-eletronica.xhtml")) && (!paginaAtual.equals("/cadastro-usuario.xhtml"))
				&& (!paginaAtual.equals("/cadastro-realizado.xhtml")) && (!paginaAtual.equals("/faleconosco.xhtml"))
				&& usuario == null) {
			// Redireciona o fluxo para a p�gina de login
			NavigationHandler nh = contexto.getApplication()
					.getNavigationHandler();
			nh.handleNavigation(contexto, null, "sair");
		} else if (isLoginPage && usuario != null) {
			// Se o usu�rio logado tentar acessar a p�gina de login ele �
			// redirecionado para a p�gina inicial
			NavigationHandler nh = contexto.getApplication()
					.getNavigationHandler();
			nh.handleNavigation(contexto, null, "sucesso");
		}

		

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		
		 System.out.println("PRINT DE IDENTIFICA��O DO EVENTO before: " +
		 event.getPhaseId());
		 
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
