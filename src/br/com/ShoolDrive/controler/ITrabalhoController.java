package br.com.ShoolDrive.controler;

import java.util.List;

import br.com.ShoolDrive.entidade.Disciplina;
import br.com.ShoolDrive.entidade.Trabalho;
import br.com.ShoolDrive.exception.RNException;

public interface ITrabalhoController {
	
	void save(Trabalho trabalho) throws RNException;
	
	void delete(Trabalho trabalho) throws RNException;

	Iterable<Trabalho> findAll()throws RNException;

	/**
	 * 
	 * @param disciplina
	 * @return
	 * @throws RNException
	 * Metodo Resposavel por Obter todos os trabalhos da disciplina passada com parametro
	 */
	List<Trabalho> findByDisciplina(Disciplina disciplina)throws RNException;

}
