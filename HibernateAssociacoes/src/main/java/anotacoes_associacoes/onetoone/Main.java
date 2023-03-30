package anotacoes_associacoes.onetoone;

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
			

    		
    		Pessoa pessoa = new Pessoa();
			pessoa.setId(2);
			pessoa.setNome("leozin");
			pessoa.setEndereco(ende);
			
			ende.setPessoa(pessoa);
			session.save(pessoa);
			
			transaction.commit();
			session.close();


		
	}catch(Exception e) {
		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
	}
		
	}

}
