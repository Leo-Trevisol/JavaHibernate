package daoGenerico;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import bean.Pessoa;
import conexao.ConexaoBD;
import conexao.HibernateUtil;

public class ExcluirPessoaDaoGenerico2 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try {
			Pessoa pessoa = new Pessoa();
			pessoa.setPes_codigo(3);
			
			DaoGenerico pessoadao = new DaoGenerico(pessoa);
			pessoadao.excluir();

		} catch (Exception e) {
			System.out.println("Erro ao excluir pessoa: " + e.getMessage());
		}

	}

}