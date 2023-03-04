package daoGenerico;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Aluno;
import bean.Pessoa;
import conexao.ConexaoBD;
import conexao.HibernateUtil;

public class ListarPessoasDaoGenerico {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		//Transaction transaction = null;
		try {
			
			Pessoa pessoa = new Pessoa();
			DaoGenerico alunodao = new DaoGenerico(pessoa);
			
			List<Pessoa> lstPessoas = new ArrayList<>();
			
			lstPessoas = alunodao.todos("Pessoa");
			
			int sizeList = lstPessoas.size();
			
			for(int i = 0; i <sizeList; i++) {
				Pessoa pess = lstPessoas.get(i);
				System.out.println(pess.toString() );
			}
			

		} catch (Exception e) {
			System.out.println("Erro ao buscar aluno: " + e.getMessage());
		}

	}

}
