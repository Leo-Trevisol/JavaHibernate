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
		
		Endereco end = (Endereco) session.get(Endereco.class, 1);
		
		System.out.println("Codigo pessoa:" + end.getId_endereco());
		System.out.println("Nome pessoa:" + end.getDesc_endereco());
		//System.out.println("Endereco:" + end.getPessoa().getNome_pessoa());
		
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
