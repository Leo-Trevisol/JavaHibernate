package anotacoes_associacoes.manytomany;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
			
			Pessoa pessoa1 = new Pessoa();
			pessoa1.setNome("marcin");
			
			Pessoa pessoa2 = new Pessoa();
			pessoa2.setNome("cesin");
			
			Set<Pessoa> lstPess = new HashSet<Pessoa>();
			lstPess.add(pessoa);
			lstPess.add(pessoa1);
			lstPess.add(pessoa2);

			
    		Endereco ende = new Endereco();
			ende.setDescricao("casa minha1");
			ende.setPessoa(lstPess);
			
			Endereco ende2 = new Endereco();
			ende2.setDescricao("casa minha2");
			ende2.setPessoa(lstPess);
			
			Endereco ende3 = new Endereco();
			ende3.setDescricao("casa minha3");
			ende3.setPessoa(lstPess);
		
			pessoa.setEndereco(new HashSet<Endereco>());
			pessoa.getEndereco().add(ende);
			pessoa.getEndereco().add(ende2);
			pessoa.getEndereco().add(ende3);

			session.save(pessoa);
			session.save(pessoa1);
			session.save(pessoa2);

			
			transaction.commit();
			session.close();


		
	}catch(Exception e) {
		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
	}
		
	}

}
