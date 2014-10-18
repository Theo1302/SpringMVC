package br.com.pacotePrincipal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.pacotePrincipal.entidade.Administrador;
import br.com.pacotePrincipal.entidade.Aluno;
import br.com.pacotePrincipal.entidade.Professor;
import br.com.pacotePrincipal.entidade.Role;

@Repository
public class AutenticacaoDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Object getbyEmail(String email) {
		Object userObject;
		userObject = this.jdbcTemplate.queryForObject("select * from aluno where email = '" + email + "'",
				new RowMapper<Aluno>() {

					@Override
					public Aluno mapRow(ResultSet rs, int arg1) throws SQLException {
						Aluno usuarioAluno = new Aluno();
						try {
							usuarioAluno.setEmail(rs.getString("email"));
							usuarioAluno.setNome(rs.getString("nome"));
							usuarioAluno.setRole(AutenticacaoDao.this.getRole(rs.getString("user_role")));
							usuarioAluno.setSenha(rs.getString("senha"));
							return usuarioAluno;
						} catch (EmptyResultDataAccessException e) {
							return null;
						} catch (Exception e) {
							return null;
						}
					}
				});
		if (userObject == null) {
			userObject = this.jdbcTemplate.queryForObject("select * from administrador where email = '" + email + "'", new RowMapper<Administrador>() {

				@Override
				public Administrador mapRow(ResultSet rs, int arg1) throws SQLException {
					Administrador usuarioAdministrador = new Administrador();
					try {
						usuarioAdministrador.setEmail(rs.getString("email"));
						usuarioAdministrador.setNome(rs.getString("nome"));
						usuarioAdministrador.setRole(AutenticacaoDao.this.getRole(rs.getString("user_role")));
						usuarioAdministrador.setSenha(rs.getString("senha"));
						return usuarioAdministrador;
					} catch (EmptyResultDataAccessException e) {
						return null;
					}catch (Exception e) {
						return null;
					}
				}
			});
		}
		if (userObject == null) {
			userObject = this.jdbcTemplate.queryForObject("select * from professor where email = '" + email + "'", new RowMapper<Professor>() {

				@Override
				public Professor mapRow(ResultSet rs, int arg1) throws SQLException {
					Professor usuarioProfessor = new Professor();
					try {
						usuarioProfessor.setEmail(rs.getString("email"));
						usuarioProfessor.setNome(rs.getString("nome"));
						usuarioProfessor.setRole(AutenticacaoDao.this.getRole(rs.getString("user_role")));
						usuarioProfessor.setSenha(rs.getString("senha"));
						return usuarioProfessor;
					} catch (EmptyResultDataAccessException e) {
						return null;
					}catch (Exception e) {
						return null;
					}
				}
			});
		}
		

		return null;
	}

	public final Role getRole(String role) {
		if (role.equals("ROLE_ADMIN")) {
			return Role.ROLE_ADMIN;
		} else if (role.equals("ROLE_PROFESSOR")) {
			return Role.ROLE_PROF;
		} else {
			return Role.ROLE_ALUNO;
		}
	}
}
