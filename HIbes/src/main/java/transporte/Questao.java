package transporte;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questao")
public class Questao {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	
	
	@Column(name = "num_pergunta")
	private int numPergunta;
	
	
	@Column(name = "pergunta")
	private String pergunta;
	
	@Column(name = "alter_a")
	private String alterA;
	
	@Column(name = "alter_b")
	private String alterB;
	
	
	@Column (name = "alter_c")
	private String alterC;
	
	@Column (name = "alter_d")
	private String alterD;
	
	@Column (name = "resposta")
	private int resposta;

	public Questao(int id, int numPergunta, String pergunta, String alterA, String alterB, String alterC, String alterD,
			int resposta) {
		super();
		this.id = id;
		this.numPergunta = numPergunta;
		this.pergunta = pergunta;
		this.alterA = alterA;
		this.alterB = alterB;
		this.alterC = alterC;
		this.alterD = alterD;
		this.resposta = resposta;
	}

	public Questao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPergunta() {
		return numPergunta;
	}

	public void setNumPergunta(int numPergunta) {
		this.numPergunta = numPergunta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getAlterA() {
		return alterA;
	}

	public void setAlterA(String alterA) {
		this.alterA = alterA;
	}

	public String getAlterB() {
		return alterB;
	}

	public void setAlterB(String alterB) {
		this.alterB = alterB;
	}

	public String getAlterC() {
		return alterC;
	}

	public void setAlterC(String alterC) {
		this.alterC = alterC;
	}

	public String getAlterD() {
		return alterD;
	}

	public void setAlterD(String alterD) {
		this.alterD = alterD;
	}

	public int getResposta() {
		return resposta;
	}

	public void setResposta(int resposta) {
		this.resposta = resposta;
	}

	
	

}
