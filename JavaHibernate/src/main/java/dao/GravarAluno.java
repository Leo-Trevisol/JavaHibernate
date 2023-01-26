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
			aluno.setAlu_codigo(1);
			aluno.setAlu_nome("Leozin");
			aluno.setAlu_fone("549840000");
			aluno.setAlu_cidade("Caxias");
			aluno.setAlu_curso("Hibernate");
			
			 session.persist(aluno);
	            
	          
			 transaction.commit();
			
			session.clear();
			
		}catch(Exception e) {
			System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
		}
		
	}

}
