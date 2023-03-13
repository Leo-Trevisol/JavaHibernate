package onetoone;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class ChipSeguranca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String numeroserial;
	
	
	@OneToOne(mappedBy="numeroSerial", fetch=FetchType.LAZY, cascade=CascadeType.ALL, orphanRemoval=true)
	private Carro carro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroserial() {
		return numeroserial;
	}

	public void setNumeroserial(String numeroserial) {
		this.numeroserial = numeroserial;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}


	
	
	
	
	
	

}
