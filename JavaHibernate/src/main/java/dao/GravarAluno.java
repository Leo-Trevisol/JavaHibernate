package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Aluno;
import conexao.ConexaoBD;

public class GravarAluno {
	
	public static void main(String[] args) {
		
			Transaction transaction = null;
	    	try {
	    		Session session = ConexaoBD.getSessionFactory().openSession();
	    		transaction = (Transaction) session.beginTransaction();
	    		
			Aluno aluno = new Aluno();
		//	aluno.setAlu_codigo(2);
			aluno.setAlu_nome("Leozi1n");
			aluno.setAlu_fone("5498401000");
			aluno.setAlu_cidade("Caxi1as");
			aluno.setAlu_curso("Hibern1ate");
			
			 session.persist(aluno);
	            
	          
			 transaction.commit();
			
			session.clear();
			
		}catch(Exception e) {
			System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
		}
		
	}

}
