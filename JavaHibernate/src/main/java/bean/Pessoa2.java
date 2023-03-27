package bean;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.IndexColumn;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKey;



@Entity
public class Pessoa2 {
	
	@Id
	@SequenceGenerator(name ="generator_pessoa", sequenceName="sequence_pessoa", allocationSize = 1)
	@GeneratedValue(generator="generator_pessoa")
	private Integer id;
	
	@Column(length = 40, nullable=false)
	private String nome;
	
	private String fone;
	
	private String cidade;
	
	private double salario;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	//Colecao usando SET:
	
	@ElementCollection
	@CollectionTable(name = "telefones_pessoa", joinColumns= @JoinColumn(name= "pessoa_id"))
//	@Column(name="tel_numero")
//	private Set<String> telefones;
	
	//Colecao usando LIST:
	
//	@IndexColumn(name="idPessoa")
//	private List<String> telefones;
	
	//Colecao com MAP:
	
	@MapKey(name="mapkey")
	private Map<String, String> telefones = new HashMap<String, String>();;
	
	
	public Integer getId() {	
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Map<String, String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Map<String, String> telefones) {
		this.telefones = telefones;
	}

//	public List<String> getTelefones() {
//		return telefones;
//	}
//
//	public void setTelefones(List<String> telefones) {
//		this.telefones = telefones;
//	}

//	public Set<String> getTelefones() {
//		return telefones;
//	}
//
//	public void setTelefones(Set<String> telefones) {
//		this.telefones = telefones;
//	}
	
	

}
