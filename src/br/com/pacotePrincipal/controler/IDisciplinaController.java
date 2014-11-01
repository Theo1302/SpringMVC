package br.com.pacotePrincipal.controler;

import java.util.List;

import br.com.pacotePrincipal.entidade.Disciplina;

public interface IDisciplinaController {
	
	public void delete(Long id);
	
	
	public Iterable<Disciplina> findAll();
	
	
	public Disciplina findOne(Long id);
	
	
	public <S extends Disciplina> S save(S disciplina);
	
	/**
	 * Recupera as disciplinas sem professor alocado
	 * @return
	 */
	public Iterable<Disciplina> listaDisciplina();
	
}
