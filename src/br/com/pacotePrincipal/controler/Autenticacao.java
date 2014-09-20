package br.com.pacotePrincipal.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pacotePrincipal.dao.UsuarioDao;
import br.com.pacotePrincipal.entidade.Usuario;


/**
 * Classe Responsavel pela autenticação do Usuario
 * 
 * @author Adriano 17/09/2014
 */
@Service
public class Autenticacao implements UserDetailsService {

	@Autowired
	private UsuarioDao usuarioDao;


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Usuario usuario = this.usuarioDao.getbyEmail(email);

		List<GrantedAuthority> listGranted = new ArrayList<GrantedAuthority>();

		if ((usuario != null) && (usuario.getRole() != null) && (usuario.getRole() != "")) {

			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(usuario.getRole());

			listGranted.add(simpleGrantedAuthority);
		}
		UserDetails user =
				new org.springframework.security.core.userdetails.User(email, usuario.getSenha(), true, true, true, true, listGranted);
		return user;
	}

}
