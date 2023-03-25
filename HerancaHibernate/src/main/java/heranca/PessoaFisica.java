package heranca;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn(name="idPessoa")
public class PessoaFisica extends Pessoa{
	
	 @Column(name = "RG", length = 10, nullable = false)     
	private String rg;
	 @Column(name = "CPF", length = 14, nullable = false)        
	private String cpf;
	 @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
	private Calendar nascimento;
	 @Column(name = "nome_usuario", length = 20, nullable = false, unique = true) 
	private String nomeusuario;
	 @Column(name = "senha", length = 10, nullable = false)   
	private String senhausuario;
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Calendar getNascimento() {
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}
	public String getNomeusuario() {
		return nomeusuario;
	}
	public void setNomeusuario(String nomeusuario) {
		this.nomeusuario = nomeusuario;
	}
	public String getSenhausuario() {
		return senhausuario;
	}
	public void setSenhausuario(String senhausuario) {
		this.senhausuario = senhausuario;
	}
	
	

}
