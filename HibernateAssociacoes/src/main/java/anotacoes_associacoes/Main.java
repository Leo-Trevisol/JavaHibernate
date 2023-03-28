package anotacoes_associacoes;

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
    		
    		Endereco ende = new Endereco();
			ende.setId(2);
			ende.setDescricao("casa minha");
		//	session.save(ende);

    		
    		Pessoa pessoa = new Pessoa();
			pessoa.setId(2);
			pessoa.setNome("leozin");
			pessoa.setEndereco(ende);
			session.save(pessoa);
			
			transaction.commit();
			session.close();


		
	}catch(Exception e) {
		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
	}
		
	}

}
