package daoGenerico;

import java.util.List;

import bean.Aluno;

public interface InterfaceDaoGenerico {
	
	public void insere();
	public void excluir();
	public void atualizar();
	public List todos();

}
