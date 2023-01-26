package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.ConexaoBD;

public class EditarAluno {

	public static void main(String[] args) {
		
		Transaction transaction = null;
    	try {
    		Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
		Aluno aluno = new Aluno();
		aluno.setAlu_codigo(1);
		aluno.setAlu_nome("Leo");
		aluno.setAlu_fone("54008080");
		aluno.setAlu_cidade("Caxias do sul");
		aluno.setAlu_curso("HibernateParte2");
		
		 session.update(aluno);
		 transaction.commit();
		
		session.clear();
		
	}catch(Exception e) {
		System.out.println("Erro ao editar aluno: " + e.getMessage());
	}
	
}

}
