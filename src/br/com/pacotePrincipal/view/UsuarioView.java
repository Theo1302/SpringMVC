package br.com.pacotePrincipal.view;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.pacotePrincipal.entidade.Usuario;

@Controller
public class UsuarioView {
	
	@RequestMapping(value = "/formUsuario", method = RequestMethod.GET)
    public ModelAndView formUsuario() {
		ModelAndView model = new ModelAndView("admin/usuario/cadastroUsuario");
		model.addObject("usuario", new Usuario());
        return model;
    }
	
	@RequestMapping("/addUsuario")
	public String addUsuario(@ModelAttribute("usuario") Usuario usuario,BindingResult result) {
		System.out.println(usuario.getEmail());
		return "";
	}
	
	
	
}
