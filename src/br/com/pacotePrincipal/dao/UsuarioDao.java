package br.com.pacotePrincipal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import br.com.pacotePrincipal.entidade.Role;
import br.com.pacotePrincipal.entidade.Usuario;

@Repository
public class UsuarioDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public Usuario getbyEmail(String email) {
		return this.jdbcTemplate.queryForObject("select * from usuario where email = '" + email + "'", new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int arg1) throws SQLException {
				Usuario usuario = new Usuario();
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setRole(Role.ROLE_ADMIN/*rs.getString("role")*/);
				usuario.setSenha(rs.getString("senha"));
				return usuario;
			}
		});
	}
}
