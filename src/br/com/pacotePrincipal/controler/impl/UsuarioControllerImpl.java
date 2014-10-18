package br.com.pacotePrincipal.controler.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pacotePrincipal.controler.IUsuarioControler;
import br.com.pacotePrincipal.dao.IAdministradorDao;
import br.com.pacotePrincipal.dao.IAlunoDao;
import br.com.pacotePrincipal.dao.IUsuarioDao;
import br.com.pacotePrincipal.entidade.Role;
import br.com.pacotePrincipal.entidade.Usuario;

@Service
public class UsuarioControllerImpl implements IUsuarioControler {

	@Autowired
	private IUsuarioDao usuarioDao;

	private IAdministradorDao administradorDao;

	private IAlunoDao alunoDao;

	public UsuarioControllerImpl() {
	}

	@Override
	public void inserir(Usuario usuario) {
		if (usuario.getRole().equals("ROLE_ADMIN")) {
			
			
			
			
			
		} else if (usuario.getRole().equals("ROLE_PROFESSOR")) {

		} else {

		}

		usuarioDao.save(usuario);
	}

	@Override
	public void deletar(Long id) {
		usuarioDao.delete(id);
	}

	@Override
	public Usuario findbyEmail(String email) {
		return usuarioDao.findByEmail(email);
	}

	@Override
	public Usuario findbyId(int id) {
		return usuarioDao.findById(id);
	}

	@Override
	public Usuario findbyRole(Role role) {
		return usuarioDao.findByRole(role);
	}

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}
}
