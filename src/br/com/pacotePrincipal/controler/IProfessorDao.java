package br.com.pacotePrincipal.controler;

import br.com.pacotePrincipal.entidade.Professor;
import br.com.pacotePrincipal.entidade.Role;

public interface IProfessorDao{
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

	// Metodos Spring

	
	public void delete(Long arg0);
	
	
	public void save(Professor arg0);
}
