package br.unipe.javaweb.controleacademico.dao;

import javax.persistence.EntityManager;

import br.unipe.javaweb.controleacademico.model.Curso;

public class CursoDAO extends AbstractDAO<Curso> {

	public CursoDAO(EntityManager entity) {
		super(entity);
	}

	@Override
	public Class<Curso> entityClass() {
		return Curso.class;
	}
	
}
