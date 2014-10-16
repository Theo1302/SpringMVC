package br.com.pacotePrincipal.controler;

import java.util.List;

import br.com.pacotePrincipal.entidade.Role;
import br.com.pacotePrincipal.entidade.Usuario;

/**
 * Responsalvel pelo as Alteraçoes de Usuario
 * @author Adriano
 *
 */
public interface IUsuarioControler {
	
	/**
	 * Insere Um usuario
	 * @param Usuario
	 */
	void inserir(Usuario usuario);
	
	/**
	 * Delete o Usuario Pelo id
	 * @param id
	 */
	void deletar(Long id);
	
	
	/**
	 * Pesquisa pelo email
	 * @param email
	 * @return Usuario
	 */
	Usuario findbyEmail(String email);
	
	/**
	 *Pesquisa pelo id 
	 * @param id
	 * @return
	 */
	Usuario findbyId(int id);
	
	/**
	 * Pesquisa pela tarefa
	 * @param role
	 * @return
	 */
	Usuario findbyRole(Role role);
	
	/**
	 * Pesquisa Todos os Usuario
	 * @return
	 */
	List<Usuario> findAll();
	
	
}
