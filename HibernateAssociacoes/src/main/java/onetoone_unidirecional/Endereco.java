package onetoone_unidirecional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
	
	@Id
	@Column(name = "id_endereco")
	private int id_endereco;
	@Column(name = "desc_endereco")
	private String desc_endereco;
	
	
	public int getId_endereco() {
		return id_endereco;
	}
	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
	public String getDesc_endereco() {
		return desc_endereco;
	}
	public void setDesc_endereco(String desc_endereco) {
		this.desc_endereco = desc_endereco;
	}
	
	

}
