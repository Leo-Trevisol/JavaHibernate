package onetoone_unidirecional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import conexao.ConexaoBD;

public class GravaPessoaEndereco {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
    	try {
    		Session session = ConexaoBD.getSessionFactory().openSession();
    		transaction = (Transaction) session.beginTransaction();
    		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setId_pessoa(1);
		pessoa.setNome_pessoa("Leozin");
		session.save(pessoa);
		
		Endereco end = new Endereco();
		
		end.setId_endereco(pessoa.getId_pessoa());
		end.setDesc_endereco("Vila amelia");
		session.save(end);
	
		
		 transaction.commit();
		
		session.clear();
		
	}catch(Exception e) {
		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
	}
	
}

}
