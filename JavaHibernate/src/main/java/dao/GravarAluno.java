package dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Aluno;
import conexao.ConexaoBD;

public class GravarAluno {
	
	public static void main(String[] args) {
		try {
			Aluno aluno = new Aluno();
		//	aluno.setAlu_codigo(2);
			aluno.setAlu_nome("1111");
			aluno.setAlu_fone("1111");
			aluno.setAlu_cidade("111");
			aluno.setAlu_curso("111");
			
			AlunoDao2 alunodao = new AlunoDao2();
			
			alunodao.insereAluno(aluno);
			
			
		}catch(Exception e) {
			System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
		}
		
	}

}
