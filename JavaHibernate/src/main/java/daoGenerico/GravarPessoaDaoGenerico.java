package daoGenerico;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.Endereco;
import bean.Pessoa;
import conexao.ConexaoBD;

public class GravarPessoaDaoGenerico {
	
	public static void main(String[] args) {
		
    		try {
		Pessoa pessoa = new Pessoa();
		
		pessoa.setPes_nome("Pessoa dao generica");
	//	pessoa.setPes_codigo();
		pessoa.setPes_email("pessoaGenerica@gmail.com");
		pessoa.setPes_sexo('m');
		pessoa.setPes_idade(15);
		pessoa.setPes_fone("25252525");
		pessoa.setPes_cpf("02444134010");
		
		Endereco endereco = new Endereco();
		
		endereco.setPes_logradouro("logradouro dao generico");
		endereco.setNumero(222);
		endereco.setComplemento("generica");
		endereco.setBairro("bairro dao generico");
		endereco.setCidade("cxs dao generica");
		
		pessoa.setPes_endereco(endereco);
		
		DaoGenerico dao = new DaoGenerico(pessoa);
		
		dao.insere();
		
		
	}catch(Exception e) {
		System.out.println("Erro ao cadastrar pessoa: " + e.getMessage());
	}
	
}

}
