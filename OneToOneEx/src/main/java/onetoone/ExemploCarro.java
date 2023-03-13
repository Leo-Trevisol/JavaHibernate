package onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class ExemploCarro {
	
	public static void main(String[] args) {
		
	
	Transaction transaction = null;
	try {
		Session session = ConexaoBD.getSessionFactory().openSession();
		transaction = (Transaction) session.beginTransaction();
		
		
		ChipSeguranca chip = new ChipSeguranca();
		chip.setNumeroserial("555555");
		session.persist(chip);
		
		Carro carro = new Carro();
		carro.setNome("MEriva");
		carro.setNumeroSerial(chip);
		session.persist(carro);
		
		transaction.commit();
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}

}