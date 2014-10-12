package br.com.pacotePrincipal.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 * Classe Responsavel pelo Controller da Disciplina
 * @author Adriano
 *
 */
@Controller
public class DisciplinaView {
	
	/**
	 * Monta o form para view
	 * @return 
	 */
	@RequestMapping(value = "/formCadastrarDisciplina" ,method = RequestMethod.GET)
	public ModelAndView formCadastroDisciplina(){
		ModelAndView model = new ModelAndView("/cadastroDisciplina");	
		return model;
	}
	
	
	/**
	 *Executa a operação de incluir
	 * @return
	 */
	@RequestMapping(value = "/incluirDisciplina" ,method = RequestMethod.GET)
	public ModelAndView incluir(){
		ModelAndView model = new ModelAndView("");	
		return model;
	}
	
	/**
	 * Lista a Disciplina para cada curso
	 * @return
	 */
	@RequestMapping(value = "/listaDisciplina" ,method = RequestMethod.GET)
	public ModelAndView formLista(){
		ModelAndView model = new ModelAndView("/listaDisciplina");
		
		
		
		return model;
	}
	

}
