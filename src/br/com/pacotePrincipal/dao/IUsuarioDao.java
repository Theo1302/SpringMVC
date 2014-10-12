package br.com.pacotePrincipal.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.pacotePrincipal.entidade.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);
	
	@Override
	public Usuario findOne(Long id);

}
