package anotacoes_associacoes.manytomany;


import java.util.Collection;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "descricao")
	private String descricao;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "endereco_pessoa", joinColumns = @JoinColumn(name="idEndereco"), 
	inverseJoinColumns = @JoinColumn(name="idPessoa"))
	@Cascade(CascadeType.ALL)
	private Collection<Pessoa> pessoa;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(Collection<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}

	
	
	

	
	
	
	
	
	
	
	

}
