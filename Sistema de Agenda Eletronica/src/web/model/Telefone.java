package web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Telefone {
	@Id @GeneratedValue
	private Long idTelefone;
	private String numeroTelefone;
	
	public Long getIdTelefone() {
		return idTelefone;
	}
	public void setIdTelefone(Long idTelefone) {
		this.idTelefone = idTelefone;
	}
	public String getNumeroTelefone() {
		return numeroTelefone;
	}
	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}
	
	
}
