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
    		
    		Pessoa pessoa = new Pessoa();
			pessoa.setId(1);
			pessoa.setNome("leozin");
			
		//	pessoa.setTelefonePessoa(telefones);
			
			Endereco ende = new Endereco();
			ende.setId(pessoa.getId());
			ende.setDescricao("casa minha");
			
			pessoa.setEndereco(ende);
			
		//	session.delete(tele);
			session.persist(pessoa);
			transaction.commit();
		
	}catch(Exception e) {
		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
	}
		
	}

}
