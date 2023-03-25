package heranca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name= "pessoa_juridica")
@PrimaryKeyJoinColumn(name="id")
public class PessoaJuridica extends Pessoa{
	
	@Column(name = "empresa")    
	private String empresa;
	@Column(name = "cargo")    
	private String cargo;
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

}
