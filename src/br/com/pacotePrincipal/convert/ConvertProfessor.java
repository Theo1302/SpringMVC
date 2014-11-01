package br.com.pacotePrincipal.convert;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pacotePrincipal.controler.IProfessorController;
import br.com.pacotePrincipal.entidade.Professor;



@Component
public class ConvertProfessor  extends PropertyEditorSupport {
	
	@Autowired
	private IProfessorController professorControler; 
	
	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		Professor professor = null;
		
		try {
			 professor = professorControler.findById(Integer.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setValue(professor);
	}
}
