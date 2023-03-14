package onetoone_unidirecional;

import java.util.ArrayList;
import java.util.List;

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
			pessoa.setId(2);
			pessoa.setNome("leozin");
			
			List<Endereco> endereco = new ArrayList<>();
			Endereco end = new Endereco();
			end.setDescricao("55555");
			end.setPessoa(pessoa);
			endereco.add(end);
			
		//	pessoa.setTelefonePessoa(telefones);
			
			Endereco ende = new Endereco();
			ende.setId(pessoa.getId());
			ende.setPessoa(pessoa);
			
		//	session.delete(tele);
			session.saveOrUpdate(pessoa);
			transaction.commit();
		
	}catch(Exception e) {
		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
	}
	
}

}
