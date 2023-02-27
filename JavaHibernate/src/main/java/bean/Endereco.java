package bean;

import jakarta.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	private String pes_logradouro;
	private int pes_numero;
	private String pes_complemento;
	private String pes_bairro;
	private String pes_cidade;
	
	public Endereco() {
		super();
	}

	public String getPes_logradouro() {
		return pes_logradouro;
	}

	public void setPes_logradouro(String pes_logradouro) {
		this.pes_logradouro = pes_logradouro;
	}

	public int getNumero() {
		return pes_numero;
	}

	public void setNumero(int numero) {
		this.pes_numero = numero;
	}

	public String getComplemento() {
		return pes_complemento;
	}

	public void setComplemento(String complemento) {
		this.pes_complemento = complemento;
	}

	public String getBairro() {
		return pes_bairro;
	}

	public void setBairro(String bairro) {
		this.pes_bairro = bairro;
	}

	public String getCidade() {
		return pes_cidade;
	}

	public void setCidade(String cidade) {
		this.pes_cidade = cidade;
	}
	
	

}
