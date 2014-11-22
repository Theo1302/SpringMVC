package br.com.ShoolDrive.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ShoolDrive.entidade.Semestre;

@Repository
public interface ISemestreDao extends CrudRepository<Semestre, Long> {

	/**
	 * Verifica se existe no banco periodo com estatos passado como parametro
	 * @param status
	 * @return a quantidade encontrado
	 */
	public long countByStatus(boolean status);
	
	/**
	 * Recupera o semestre com status passado
	 * @param status
	 * @return
	 */
	public Semestre findByStatus(boolean status);
	
	public Iterable<Semestre> findAllByOrderByStatusDesc(); 
	
	@Override
	public <S extends Semestre> S save(S semestre);
	
	
	@Override
	public Iterable<Semestre> findAll();
	
	
	@Override
	public Semestre findOne(Long id);
	
	/*@Query("SELECT id, ano_semestre, status FROM semestre ORDER By status desc")
	public List<Semestre> todos();*/
	
}
