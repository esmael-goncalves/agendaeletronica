package web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
	

@Entity
public class FaleConosco {
	@Id @GeneratedValue
	private Long idFaleConosco;
	@NotNull
	private String nomeUserFaleConosco;
	@NotNull
	private String emailUserFaleConosco;
	@NotNull
	private String assuntoUserFaleConosco;
	@NotNull
	private String messageUserFaleConosoco;
	
	public Long getIdFaleConosco() {
		return idFaleConosco;
	}
	public void setIdFaleConosco(Long idFaleConosco) {
		this.idFaleConosco = idFaleConosco;
	}
	public String getNomeUserFaleConosco() {
		return nomeUserFaleConosco;
	}
	public void setNomeUserFaleConosco(String nomeUserFaleConosco) {
		this.nomeUserFaleConosco = nomeUserFaleConosco;
	}
	public String getEmailUserFaleConosco() {
		return emailUserFaleConosco;
	}
	public void setEmailUserFaleConosco(String emailUserFaleConosco) {
		this.emailUserFaleConosco = emailUserFaleConosco;
	}
	public String getAssuntoUserFaleConosco() {
		return assuntoUserFaleConosco;
	}
	public void setAssuntoUserFaleConosco(String assuntoUserFaleConosco) {
		this.assuntoUserFaleConosco = assuntoUserFaleConosco;
	}
	public String getMessageUserFaleConosoco() {
		return messageUserFaleConosoco;
	}
	public void setMessageUserFaleConosoco(String messageUserFaleConosoco) {
		this.messageUserFaleConosoco = messageUserFaleConosoco;
	}
	
	
	
}
