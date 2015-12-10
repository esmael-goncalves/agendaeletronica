package web.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;



@Entity
public class Contato {
	@Id @GeneratedValue
	private Long idContato;
	@NotNull
	private String nomeContato;
	private Calendar nascimentoContato = new GregorianCalendar();
	private String enderecoContato;
	private String codigoPostalContato;
	private String cidadeContato;
	private String estadoContato;
	private String paisContato;
	@OneToMany (cascade = CascadeType.ALL)
	private List<Telefone>telefoneContato;
	@NotNull
	private String emailContato;
	@ManyToOne
	private Usuario usuario;
	
	public Long getIdContato() {
		return idContato;
	}
	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}
	public String getNomeContato() {
		return nomeContato;
	}
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	public Calendar getNascimentoContato() {
		return nascimentoContato;
	}
	public void setNascimentoContato(Calendar nascimentoContato) {
		this.nascimentoContato = nascimentoContato;
	}
	public String getEnderecoContato() {
		return enderecoContato;
	}
	public void setEnderecoContato(String enderecoContato) {
		this.enderecoContato = enderecoContato;
	}
	public String getCodigoPostalContato() {
		return codigoPostalContato;
	}
	public void setCodigoPostalContato(String codigoPostalContato) {
		this.codigoPostalContato = codigoPostalContato;
	}
	public String getCidadeContato() {
		return cidadeContato;
	}
	public void setCidadeContato(String cidadeContato) {
		this.cidadeContato = cidadeContato;
	}
	public String getEstadoContato() {
		return estadoContato;
	}
	public void setEstadoContato(String estadoContato) {
		this.estadoContato = estadoContato;
	}
	public String getPaisContato() {
		return paisContato;
	}
	public void setPaisContato(String paisContato) {
		this.paisContato = paisContato;
	}

	public List<Telefone> getTelefoneContato() {
		return telefoneContato;
	}
	public void setTelefoneContato(List<Telefone> telefoneContato) {
		this.telefoneContato = telefoneContato;
	}
	public String getEmailContato() {
		return emailContato;
	}
	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
