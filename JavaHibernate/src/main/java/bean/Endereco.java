package bean;

public class Endereco {
	
	private String pes_logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	
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
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	

}
