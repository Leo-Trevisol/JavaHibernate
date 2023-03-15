package onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;


@Entity
public class Pessoa {
	
	private String nome;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy= "pessoa", orphanRemoval=true)
	@Cascade(CascadeType.ALL)
	private List<TelefonePessoa> telefonePessoa = new ArrayList<>();
	
	@ManyToMany
	@Cascade(CascadeType.ALL)
	@JoinTable(name="pessoa_projeto", joinColumns= {@JoinColumn(name="pessoa_id")}, 
	inverseJoinColumns= {@JoinColumn(name="projeto_id")})

	private List<Projeto> projetos = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<TelefonePessoa> getTelefonePessoa() {
		return telefonePessoa;
	}

	public void setTelefonePessoa(List<TelefonePessoa> telefonePessoa) {
		this.telefonePessoa = telefonePessoa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	
	
	

}
