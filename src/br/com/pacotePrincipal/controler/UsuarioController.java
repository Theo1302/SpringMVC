package br.com.pacotePrincipal.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pacotePrincipal.dao.IUsuarioDao;

@Service
public class UsuarioController {
	
	@Autowired
	private IUsuarioDao iusuarioDao;
	
	public void	usuario(int id) {
		System.out.println(iusuarioDao.findByEmail("tel").getNome());
	}
}
