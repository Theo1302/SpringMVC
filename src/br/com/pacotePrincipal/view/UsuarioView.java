package br.com.pacotePrincipal.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.pacotePrincipal.controler.IUsuarioControler;
import br.com.pacotePrincipal.entidade.Usuario;
import br.com.pacotePrincipal.util.Mensagems;
import br.com.pacotePrincipal.util.TipoMensagem;

@Controller
public class UsuarioView {
	/********* PATH DA PAGINAS ***********/
	private final String CADASTRO_USUARIO = "admin/usuario/cadastroUsuario";
	private final String LISTA_USUARIO = "admin/usuario/listaUsuario";

	@Autowired
	private IUsuarioControler usuarioControler;

	@RequestMapping(value = "/formUsuario", method = RequestMethod.GET)
	public ModelAndView formUsuario() {
		ModelAndView model = new ModelAndView(CADASTRO_USUARIO);
		model.addObject("usuario", new Usuario());
		return model;
	}

	@RequestMapping("/addUsuario")
	public ModelAndView addUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult result) {
		ModelAndView model = new ModelAndView(CADASTRO_USUARIO);

		if (usuario.getRole().equals("ROLE_ADMIN")) {
			
		}
		else if (usuario.getRole().equals("ROLE_PROFESSOR")) {

		}
		else{

		}

		try {
			usuarioControler.inserir(usuario);
			model.addObject(TipoMensagem.VARIAVEL_VIEW.getValor(), TipoMensagem.SUCESSO.getValor());
			model.addObject(Mensagems.VARIAVEL_VIEW.getMensagem(), Mensagems.UsuarioCadastrado.getMensagem());
		} catch (Exception e) {

		}
		return model;
	}

	@RequestMapping("/listaUsuario")
	private ModelAndView listaUsuario() {
		ModelAndView model = new ModelAndView(LISTA_USUARIO);
		model.addObject("usuarios", usuarioControler.findAll());
		return model;
	}

	@RequestMapping("/excluirUsuario")
	private ModelAndView excluirUsuario(@RequestParam("id") Long id) {
		ModelAndView model = new ModelAndView();
		try {
			usuarioControler.deletar(id);
			model.addObject(TipoMensagem.VARIAVEL_VIEW.getValor(), TipoMensagem.SUCESSO.getValor());
			model.addObject(Mensagems.VARIAVEL_VIEW.getMensagem(), Mensagems.UsuarioExcluido.getMensagem());
		} catch (Exception e) {
			model.addObject(TipoMensagem.VARIAVEL_VIEW.getValor(), TipoMensagem.ERRO.getValor());
			model.addObject(Mensagems.VARIAVEL_VIEW.getMensagem(), Mensagems.ErroOperacaoUsuario.getMensagem());
		}

		model = this.listaUsuario();
		return model;

	}
}
