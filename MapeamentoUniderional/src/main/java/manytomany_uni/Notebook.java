package manytomany_uni;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="notebook")
public class Notebook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String serialNumber;
    private int ramMemoryTotal;
    private int hdSpaceTotal;
       public int getId() {
             return id;
       }
       public void setId(int id) {
             this.id = id;
       }
       public String getSerialNumber() {
             return serialNumber;
       }
       public void setSerialNumber(String serialNumber) {
             this.serialNumber = serialNumber;
       }
       public int getRamMemoryTotal() {
             return ramMemoryTotal;
       }
       public void setRamMemoryTotal(int ramMemoryTotal) {
             this.ramMemoryTotal = ramMemoryTotal;
       }
       public int getHdSpaceTotal() {
             return hdSpaceTotal;
       }
       public void setHdSpaceTotal(int hdSpaceTotal) {
             this.hdSpaceTotal = hdSpaceTotal;
       }


}
