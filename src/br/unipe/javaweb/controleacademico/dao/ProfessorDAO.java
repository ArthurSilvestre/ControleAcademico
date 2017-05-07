package br.unipe.javaweb.controleacademico.dao;

import javax.persistence.EntityManager;

import br.unipe.javaweb.controleacademico.model.Professor;

public class ProfessorDAO extends AbstractDAO<Professor> {

	public ProfessorDAO(EntityManager entity) {
		super(entity);
	}

	@Override
	public Class<Professor> entityClass() {
		return Professor.class;
	}

	/*
	public List<Professor> listarMovimentosPorConta(Long id) {
		Query query = manager.createQuery("select m from Movimento m where m.conta.id = :idConta");
		query.setParameter("idConta", id);
		return query.getResultList();
	}

	public List<Professor> listarMovimentosDaContaPorTipo(Long id, String filtro) {
		Query query = manager.createQuery("select m from Movimento m where m.conta.id = :idConta and m.tipoOperacao = :tipoOperacao");
		query.setParameter("idConta", id);
		if(filtro.equals("CREDITO")){
			query.setParameter("tipoOperacao", TipoOperacao.CREDITO);
		}else{
			query.setParameter("tipoOperacao", TipoOperacao.DEBITO);
		}
		return query.getResultList();
	}
	*/
	
}
