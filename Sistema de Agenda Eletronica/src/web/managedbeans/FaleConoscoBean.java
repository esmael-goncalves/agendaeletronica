package web.managedbeans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import org.apache.commons.mail.EmailException;

import web.model.FaleConosco;
import web.repository.FaleConoscoRepository;
import web.util.EmailService;

@ManagedBean
public class FaleConoscoBean {

	@ManagedProperty(value = "#{entityManager}")
	private EntityManager entityManager;

	FaleConosco faleConosco = new FaleConosco();
	private List<FaleConosco> faleConoscoList;

	private boolean receberEmail;

	@SuppressWarnings("finally")
	public String adiciona() {
		FaleConoscoRepository repository = new FaleConoscoRepository(
				this.entityManager);
		repository.adiciona(this.faleConosco);

		if (receberEmail) {
			try {
				EmailService.sendMailFaleConosco(EmailService.emailFaleConosco(
						faleConosco.getNomeUserFaleConosco(),
						faleConosco.getEmailUserFaleConosco(),
						faleConosco.getAssuntoUserFaleConosco(),
						faleConosco.getMessageUserFaleConosoco()), faleConosco
						.getEmailUserFaleConosco());
			} catch (EmailException e) {

				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,"Erro: ",
						"Não foi possível enviar a cópia por email.");

				FacesContext.getCurrentInstance().addMessage(null, msg);
			} finally {
				this.faleConosco = new FaleConosco();
				this.faleConosco = null;
				
				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_INFO,"Sucesso: ",
						"Sua mensagem foi enviada do Admininistrador do sistema");

				FacesContext.getCurrentInstance().addMessage(null, msg);
				return "indexout";
			}
		}

		return "";

	}

	public void remove(FaleConosco faleConosco) {
		FaleConoscoRepository repository = new FaleConoscoRepository(
				this.entityManager);
		repository.remove(faleConosco);
		this.faleConosco = null;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public FaleConosco getFaleConosco() {
		return faleConosco;
	}

	public void setFaleConosco(FaleConosco faleConosco) {
		this.faleConosco = faleConosco;
	}

	public List<FaleConosco> getFaleConoscoList() {
		if (this.faleConoscoList == null) {
			System.out.println("CHAMANDO O REPOSITORIO");
			FaleConoscoRepository repository = new FaleConoscoRepository(
					this.entityManager);
			this.faleConoscoList = repository.getFaleConosco();
		}
		return this.faleConoscoList;
	}

	public void setFaleConoscoList(List<FaleConosco> faleConoscoList) {
		this.faleConoscoList = faleConoscoList;
	}

	public boolean isReceberEmail() {
		return receberEmail;
	}

	public void setReceberEmail(boolean receberEmail) {
		this.receberEmail = receberEmail;
	}

}
