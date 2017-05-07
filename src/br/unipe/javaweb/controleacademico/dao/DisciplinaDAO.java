package br.unipe.javaweb.controleacademico.dao;

import javax.persistence.EntityManager;

import br.unipe.javaweb.controleacademico.model.Disciplina;

public class DisciplinaDAO extends AbstractDAO<Disciplina> {

	public DisciplinaDAO(EntityManager entity) {
		super(entity);
	}

	@Override
	public Class<Disciplina> entityClass() {
		return Disciplina.class;
	}
	
}
