package bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findAluno",  
	        query = "from Aluno where alu_nome = :name"  
	        )  
	    }  
	)  

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable{
	


	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int alu_codigo;
	@Column
	private String alu_nome;
	@Column
	private String alu_cidade;
	@Column
	private String alu_fone;
	@Column
	private String alu_curso;
	
//	
//	@OneToMany
//	@JoinTable(name="telefones_alunos", joinColumns=@JoinColumn(name="tel_codaluno"))
//	@Column(name="tel_numero")
//	private Set<String> telefones_aluno = new HashSet<String>();
	
	public Aluno() {
	}

	public int getAlu_codigo() {
		return alu_codigo;
	}

	public void setAlu_codigo(int alu_codigo) {
		this.alu_codigo = alu_codigo;
	}

	public String getAlu_nome() {
		return alu_nome;
	}

	public void setAlu_nome(String alu_nome) {
		this.alu_nome = alu_nome;
	}

	public String getAlu_cidade() {
		return alu_cidade;
	}

	public void setAlu_cidade(String alu_cidade) {
		this.alu_cidade = alu_cidade;
	}

	public String getAlu_fone() {
		return alu_fone;
	}

	public void setAlu_fone(String alu_fone) {
		this.alu_fone = alu_fone;
	}

	public String getAlu_curso() {
		return alu_curso;
	}

	public void setAlu_curso(String alu_curso) {
		this.alu_curso = alu_curso;
	}
	
//	public Set<String> getTelefones_aluno() {
//		return telefones_aluno;
//	}
//
//	public void setTelefones_aluno(Set<String> telefones_aluno) {
//		this.telefones_aluno = telefones_aluno;
//	}

	@Override
	public String toString() {
		return "Aluno [alu_codigo=" + alu_codigo + ", alu_nome=" + alu_nome + ", alu_cidade=" + alu_cidade
				+ ", alu_fone=" + alu_fone + ", alu_curso=" + alu_curso + "]";
	}

	
	
	

	

}
