package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import conexao.HibernateUtil;

public class AlunoDao2 implements InterfaceAlunoDao{
	
	private final Session session;
	
	public AlunoDao2() {
		this.session = HibernateUtil.getSession();
	}
	

	@Override
	public void insereAluno(Aluno aluno) {
		
		try {
		Transaction transAluno = session.beginTransaction();
		session.save(aluno);
		transAluno.commit();
		
		}catch(HibernateException e ) {
			System.out.println("Erro ao inserir aluno: " + e.getMessage());
		}
	}

	@Override
	public void excluirAluno(Aluno aluno) {
		try {
		Transaction transAluno = session.beginTransaction();
		session.remove(aluno);
		transAluno.commit();
		}catch(HibernateException e ) {
			System.out.println("Erro ao deletar aluno: " + e.getMessage());
		}
	}

	@Override
	public void atualizaAluno(Aluno aluno) {
		try {
		Transaction transAluno = session.beginTransaction();
		session.update(aluno);
		transAluno.commit();
		}catch(HibernateException e ) {
			System.out.println("Erro ao atualizar aluno: " + e.getMessage());
		}
	}
	
	@Override
	public List todosAlunos() {
		List listaAlunos = session.createQuery("from Aluno").list();
		
		return listaAlunos;
		
	}

}
