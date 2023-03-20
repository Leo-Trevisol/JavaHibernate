package manytomany_uni;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class Main {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		try {
			Session session = ConexaoBD.getSessionFactory().openSession();
			transaction = (Transaction) session.beginTransaction();
			
			Pessoa pessoa = new Pessoa();
			
			pessoa.setName("leo");
			pessoa.setCompanyName("leozicp");
			
			List<Notebook> lstNb = new ArrayList<>();
			Notebook nb = new Notebook();
			nb.setSerialNumber("number1");
			nb.setRamMemoryTotal(8);
			nb.setHdSpaceTotal(500);
			
			lstNb.add(nb);
			
			Notebook nb2 = new Notebook();
			nb2.setSerialNumber("number2");
			nb2.setRamMemoryTotal(16);
			nb2.setHdSpaceTotal(1000);
			
			lstNb.add(nb2);
			
			pessoa.setNotebooks(lstNb);
			
			session.persist(pessoa);
			transaction.commit();
			
			
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
