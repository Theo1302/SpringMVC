package br.com.pacotePrincipal.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.pacotePrincipal.entidade.Semestre;

@Repository
public interface ISemestreDao extends CrudRepository<Semestre, Long> {

	/**
	 * Verifica se existe no banco periodo com estatos passado como parametro
	 * @param status
	 * @return a quantidade encontrado
	 */
	public long countByStatus(boolean status);
	
	@Override
	public <S extends Semestre> S save(S semestre);
	
	
	@Override
	public Iterable<Semestre> findAll();
	
	
	@Override
	public Semestre findOne(Long id);
	
	
}
