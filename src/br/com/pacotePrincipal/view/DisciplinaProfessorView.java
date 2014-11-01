package br.com.pacotePrincipal.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.pacotePrincipal.controler.IDisciplinaController;
import br.com.pacotePrincipal.controler.IProfessorController;
import br.com.pacotePrincipal.convert.ConvertDisciplina;
import br.com.pacotePrincipal.convert.ConvertProfessor;
import br.com.pacotePrincipal.entidade.Disciplina;
import br.com.pacotePrincipal.entidade.Professor;
import br.com.pacotePrincipal.util.Mensagems;
import br.com.pacotePrincipal.util.TipoMensagem;

@Controller
@Secured("ROLE_ADMIN")
public class DisciplinaProfessorView {
	
	private final String VIEW_ALOCAR_PROFESSOR = "admin/outros/alocarProfesso";
	
	@Autowired
	private IProfessorController professorController;
	
	@Autowired
	private IDisciplinaController disciplinaController;
	
	@Autowired
	private ConvertDisciplina convertDisciplina;
	
	@Autowired
	private ConvertProfessor convertProfessor;

	
	/**
	 * Responsavel por inicializar os converts e registralos no jsp
	 * 
	 * @param webDataBinder
	 */
	@InitBinder
	public void intblind(WebDataBinder binder) {
		binder.registerCustomEditor(Disciplina.class, this.convertDisciplina);
		binder.registerCustomEditor(Professor.class, this.convertProfessor);
	}
	
	@RequestMapping(value = "/formAlocarProfessor", method = RequestMethod.GET)
	public ModelAndView formAlocarProfessor(){
		ModelAndView model = new ModelAndView(VIEW_ALOCAR_PROFESSOR);
		model.addObject("professores", professorController.findAll());
		model.addObject("disciplinas", disciplinaController.listaDisciplina());
		return model;
	}
	

	/**
	 * Executa a operação de incluir
	 * 
	 * @return
	 */
	@RequestMapping(value = "/alocarProfessor", method = RequestMethod.POST)
	public ModelAndView alocar(BindingResult result,HttpServletRequest request, RedirectAttributes redirect) {
		ModelAndView model = new ModelAndView(VIEW_ALOCAR_PROFESSOR);
		Disciplina disciplina;
		Professor professor;
		try {
			disciplina = disciplinaController.findOne(Long.valueOf(request.getParameter("disciplina")));
			professor = professorController.findById(Integer.valueOf(request.getParameter("professor")));
			
			//Adiciona o professor a disciplina
			disciplina.setProfessor(professor);
			disciplinaController.save(disciplina);
			
			model.addObject(TipoMensagem.VARIAVEL_VIEW.getValor(), TipoMensagem.SUCESSO.getValor());
			model.addObject(Mensagems.VARIAVEL_VIEW.getMensagem(), "Professor Alocado A disciplina !!");
			
			model.addObject("professores", professorController.findAll());
			model.addObject("disciplinas", disciplinaController.listaDisciplina());
			//model = this.reload(model);
		} catch (Exception e) {
			model.setViewName("/home");
			model.addObject(TipoMensagem.VARIAVEL_VIEW.getValor(), TipoMensagem.ERRO.getValor());
			model.addObject(Mensagems.VARIAVEL_VIEW.getMensagem(), "Ocorreu um erro !");
		}
		return model;
	}
}
