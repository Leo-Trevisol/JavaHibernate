package heranca;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class Main {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
    	try {
    		Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
    		PessoaFisica pessf = new PessoaFisica();
    		
    		pessf.setNome("Leonardo");
    		pessf.setFone("51515151");
    		pessf.setCpf("0241141414");
    		pessf.setRg("5858585800");
    		pessf.setSexo('M');
    		pessf.setCidade("Caxias");
    		
    		
    		PessoaJuridica pessj = new PessoaJuridica();
    		
    		pessj.setNome("Leonardo");
    		pessj.setFone("51515151");
    		pessj.setCidade("Caxias");
    		pessj.setGerente("Leo");
    		pessj.setInscr_estad("Numero 2");
    		pessj.setCnpj("15151515");
    		
    		session.persist(pessf);
    		session.persist(pessj);
    		transaction.commit();
    		
    		
    	}catch(Exception e) {
    		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
    	}
	}

}
