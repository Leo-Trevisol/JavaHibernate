package heranca;

import java.util.Calendar;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pessoa_fisica")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PessoaFisica extends Pessoa{
	
	private String cpf;
	 
	private String rg;
	
	private char sexo;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	


}
