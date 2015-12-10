package web.model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {
	@Id @GeneratedValue
	private Long idUsuario;
	@NotNull 
	private String nomeUsuario;
	private Calendar nascimentoUsuario = new GregorianCalendar();
	private String enderecoUsuario;
	private String codigoPostalusuario;
	private String cidadeUsuario;
	private String estadoUsuario;
	private String paisUsuario;
	@OneToMany (cascade = CascadeType.ALL)
	private List<Telefone> telefoneUsuario;
	@NotNull
	private String emailUsuario;
	@NotNull
	private String perguntaSecretaUsuario;
	@NotNull
	private String respostaSecretaUsuario;
	@NotNull
	private String senhaUsuario;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public Calendar getNascimentoUsuario() {
		return nascimentoUsuario;
	}
	public void setNascimentoUsuario(Calendar nascimentoUsuario) {
		this.nascimentoUsuario = nascimentoUsuario;
	}
	public String getEnderecoUsuario() {
		return enderecoUsuario;
	}
	public void setEnderecoUsuario(String enderecoUsuario) {
		this.enderecoUsuario = enderecoUsuario;
	}
	public String getCodigoPostalusuario() {
		return codigoPostalusuario;
	}
	public void setCodigoPostalusuario(String codigoPostalusuario) {
		this.codigoPostalusuario = codigoPostalusuario;
	}
	public String getCidadeUsuario() {
		return cidadeUsuario;
	}
	public void setCidadeUsuario(String cidadeUsuario) {
		this.cidadeUsuario = cidadeUsuario;
	}
	public String getEstadoUsuario() {
		return estadoUsuario;
	}
	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	public String getPaisUsuario() {
		return paisUsuario;
	}
	public void setPaisUsuario(String paisUsuario) {
		this.paisUsuario = paisUsuario;
	}
	
	public List<Telefone> getTelefoneUsuario() {
		return telefoneUsuario;
	}
	public void setTelefoneUsuario(List<Telefone> telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
			
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	public String getPerguntaSecretaUsuario() {
		return perguntaSecretaUsuario;
	}
	public void setPerguntaSecretaUsuario(String perguntaSecretaUsuario) {
		this.perguntaSecretaUsuario = perguntaSecretaUsuario;
	}
	public String getRespostaSecretaUsuario() {
		return respostaSecretaUsuario;
	}
	public void setRespostaSecretaUsuario(String respostaSecretaUsuario) {
		this.respostaSecretaUsuario = respostaSecretaUsuario;
	}
	

}
