package br.com.pacotePrincipal.convert;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.pacotePrincipal.controler.IDisciplinaController;
import br.com.pacotePrincipal.entidade.Disciplina;

@Component
public class ConvertDisciplina extends PropertyEditorSupport {
	
	@Autowired
	private IDisciplinaController disciplinaController; 
	
	@Override
	public void setAsText(String id) throws IllegalArgumentException {
		Disciplina disciplina = null;
		
		try {
			disciplina = disciplinaController.findOne(Long.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.setValue(disciplina);
	}
}
