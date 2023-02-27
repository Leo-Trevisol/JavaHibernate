package bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pes_codigo;
	@Column
	private String pes_nome;
	@Column
	private String  pes_email;
	@Column
	private char  pes_sexo;
	@Column
	private int  pes_idade;
	@Column
	private String  pes_fone;
	@Column
	private String  pes_cpf;
	
	private Endereco pes_endereco;
	
	
	
	public Pessoa() {
		super();
	}



	public int getPes_codigo() {
		return pes_codigo;
	}



	public void setPes_codigo(int pes_codigo) {
		this.pes_codigo = pes_codigo;
	}



	public String getPes_nome() {
		return pes_nome;
	}



	public void setPes_nome(String pes_nome) {
		this.pes_nome = pes_nome;
	}



	public String getPes_email() {
		return pes_email;
	}



	public void setPes_email(String pes_email) {
		this.pes_email = pes_email;
	}



	public char getPes_sexo() {
		return pes_sexo;
	}



	public void setPes_sexo(char pes_sexo) {
		this.pes_sexo = pes_sexo;
	}



	public int getPes_idade() {
		return pes_idade;
	}



	public void setPes_idade(int pes_idade) {
		this.pes_idade = pes_idade;
	}



	public String getPes_fone() {
		return pes_fone;
	}



	public void setPes_fone(String pes_fone) {
		this.pes_fone = pes_fone;
	}



	public String getPes_cpf() {
		return pes_cpf;
	}



	public void setPes_cpf(String pes_cpf) {
		this.pes_cpf = pes_cpf;
	}



	public Endereco getPes_endereco() {
		return pes_endereco;
	}



	public void setPes_endereco(Endereco pes_endereco) {
		this.pes_endereco = pes_endereco;
	}
	

	
	

}
