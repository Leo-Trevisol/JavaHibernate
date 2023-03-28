package anotacoes_associacoes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class DeletarPessoaEndereco {
	
	public static void main(String[] args) {
		
	Transaction transaction = null;
	try {
		Session session = ConexaoBD.getSessionFactory().openSession();
		transaction = (Transaction) session.beginTransaction();
		
		Pessoa pessoa = (Pessoa) session.get(Pessoa.class, 1);
		
		session.delete(pessoa);
		transaction.commit();
		session.close();
	
}catch(Exception e) {
	e.printStackTrace();
}

	}
}
