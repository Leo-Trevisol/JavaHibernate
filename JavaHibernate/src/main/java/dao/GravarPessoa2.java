package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Pessoa2;
import conexao.ConexaoBD;

public class GravarPessoa2 {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
    	try {
    		Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
    		Pessoa2 pess = new Pessoa2();
    		
    		pess.setNome("leozin");
    		pess.setFone("00002020");
    		pess.setCidade("Caxas");
    		pess.setSalario(200.00);
    		pess.setDataCadastro(new Date());
    		pess.setDataNascimento(new Date());
    		
    		pess.setTelefones(new HashMap<String, String>());
    		pess.getTelefones().put("1", "984081674");
    		pess.getTelefones().put("2", "991763517");
    		pess.getTelefones().put("3", "991763517");


    		
    		
    		session.persist(pess);
    		transaction.commit();
    		

    		
    	}catch(Exception e) {
    		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
    	}
	}

}
