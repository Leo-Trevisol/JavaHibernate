package onetoone_unidirecional;

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
		
		System.out.println("Codigo pessoa:" + pessoa.getId_pessoa());
		System.out.println("Nome pessoa:" + pessoa.getNome_pessoa());
		System.out.println("Endereco:" + pessoa.getEndereco().getDesc_endereco());
		
//		Endereco end = (Endereco) session.get(Endereco.class, 1);
//		
//		System.out.println("Codigo pessoa:" + end.getId_endereco());
//		System.out.println("Nome pessoa:" + end.getDesc_endereco());

	
	session.close();
	
}catch(Exception e) {
	e.printStackTrace();
}

}

}
