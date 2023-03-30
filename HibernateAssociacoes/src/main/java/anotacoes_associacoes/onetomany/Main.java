package anotacoes_associacoes.onetomany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
			pessoa.setNome("leozin");
			    		
    		Endereco ende = new Endereco();
			ende.setDescricao("casa minha1");
			ende.setPessoa(pessoa);
			
			Endereco ende2 = new Endereco();
			ende2.setDescricao("casa minha2");
			ende2.setPessoa(pessoa);
			
			Endereco ende3 = new Endereco();
			ende3.setDescricao("casa minha3");
			ende3.setPessoa(pessoa);
			
			pessoa.setEndereco(new HashSet<Endereco>());
			pessoa.getEndereco().add(ende);
			pessoa.getEndereco().add(ende2);
			pessoa.getEndereco().add(ende3);

			session.save(pessoa);
			
			transaction.commit();
			session.close();


		
	}catch(Exception e) {
		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
	}
		
	}

}
