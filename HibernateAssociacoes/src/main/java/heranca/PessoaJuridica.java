package heranca;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name= "pessoa_juridica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PessoaJuridica extends Pessoa{
	
	private String cnpj;
	
	private String inscr_estad;
	
	private String gerente;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscr_estad() {
		return inscr_estad;
	}

	public void setInscr_estad(String inscr_estad) {
		this.inscr_estad = inscr_estad;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	
	
	

}
