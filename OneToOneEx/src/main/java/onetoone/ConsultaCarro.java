package onetoone;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class ConsultaCarro {
	
	public static void main(String[] args) {
		
		
		Transaction transaction = null;
		try {
			
			Session session = ConexaoBD.getSessionFactory().openSession();
			transaction = (Transaction) session.beginTransaction();
			
			Carro carro = session.find(Carro.class,4);
			ChipSeguranca chip = (ChipSeguranca) carro.getNumeroSerial();
			
			System.out.println(carro);
			System.out.println(chip);
			System.out.println();
			
			ChipSeguranca chip2 = (ChipSeguranca) session.find(ChipSeguranca.class,4);
			System.out.println(chip2);
			System.out.println(chip.getCarro().toString());
			
			
		
		
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}

}


}
