package anotacoes_associacoes;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class ListaPessoaEndereco {
	public static void main(String[] args) {

	Transaction transaction = null;
	try {
		Session session = ConexaoBD.getSessionFactory().openSession();
		transaction = (Transaction) session.beginTransaction();
		
		Pessoa pessoa = (Pessoa) session.get(Pessoa.class, 1);
		
		System.out.println("Codigo pessoa:" + pessoa.getId());
		System.out.println("Nome pessoa:" + pessoa.getNome());
		System.out.println("Endereco:" + pessoa.getEndereco());
		
		Endereco end = (Endereco) session.get(Endereco.class, 2);
		
		System.out.println("Codigo pessoa:" + end.getId());
		System.out.println("Nome pessoa:" + end.getDescricao());

	
	session.close();
	
}catch(Exception e) {
	e.printStackTrace();
}

}

}
