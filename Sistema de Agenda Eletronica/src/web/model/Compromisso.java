package web.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;



@Entity
public class Compromisso {
	@Id @GeneratedValue
	private Long idCompromisso;
	@NotNull
	private String nome;
	@NotNull
	private Calendar dataInicio = new GregorianCalendar();
	@NotNull
	private Calendar dataTermino = new GregorianCalendar();
	@NotNull
	private String local;
	private String descricao;
	@ManyToOne
	private Usuario usuario;
	
	public Long getIdCompromisso() {
		return idCompromisso;
	}
	public void setIdCompromisso(Long idCompromisso) {
		this.idCompromisso = idCompromisso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Calendar getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
