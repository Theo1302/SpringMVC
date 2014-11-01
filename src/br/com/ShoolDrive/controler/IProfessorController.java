package br.com.ShoolDrive.controler;

import java.util.List;

import br.com.ShoolDrive.entidade.Professor;
import br.com.ShoolDrive.entidade.Role;
import br.com.ShoolDrive.entidade.Usuario;

public interface IProfessorController{
	/**
	 * Pesquisa pelo email
	 * 
	 * @param email
	 * @return Usuario
	 */
	Professor findByEmail(String email);

	/**
	 * Pesquisa pelo id
	 * 
	 * @param id
	 * @return
	 */
	Professor findById(int id);

	/**
	 * Pesquisa pela role
	 * 
	 * @param role
	 * @return
	 */
	Professor findByRole(Role role);

	
	/**
	 * Pesquisa Todos os Usuario
	 * @return
	 */
	List<Professor> findAll();
	// Metodos Spring

	
	public void delete(Long arg0);
	
	
	public void save(Professor arg0);
}
