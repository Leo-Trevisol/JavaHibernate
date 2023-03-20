package manytomany_uni;

import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

//Using the * to make the import list smaller

@Entity
@Table(name = "Pessoa")
@SecondaryTable(name = "health_care", pkJoinColumns =
{ @PrimaryKeyJoinColumn(name = "id") })
public class Pessoa {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  @Column
  private String name;

  @Column(table = "health_care", name = "company_name")
  @Cascade(CascadeType.ALL)
  private String companyName;

  @ManyToMany
  @JoinTable(name="pessoa_has_notebooks", joinColumns=
  {@JoinColumn(name="pessoa_id")}, inverseJoinColumns=
    {@JoinColumn(name="notebook_id")})
  @Cascade(CascadeType.ALL)
  private List<Notebook> notebooks;

     public int getId() {
           return id;
     }

     public void setId(int id) {
           this.id = id;
     }

     public String getName() {
           return name;
     }

     public void setName(String name) {
           this.name = name;
     }

     public String getCompanyName() {
           return companyName;
     }

     public void setCompanyName(String companyName) {
           this.companyName = companyName;
     }

	public List<Notebook> getNotebooks() {
		return notebooks;
	}

	public void setNotebooks(List<Notebook> notebooks) {
		this.notebooks = notebooks;
	}

  


}