package br.unipe.javaweb.controleacademico.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unipe.javaweb.controleacademico.model.Usuario;



public class UsuarioDAO extends AbstractDAO<Usuario> {

	public UsuarioDAO(EntityManager entity) {
		super(entity);
	}

	@Override
	public Class<Usuario> entityClass() {
		return Usuario.class;
	}
	
	@SuppressWarnings("unchecked")
	public Usuario efetuaLogin(String login, String senha){
		Query query = manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
		query.setParameter("login", login);
		query.setParameter("senha", senha);
		List<Usuario> usuarios = query.getResultList();
		
		if(!usuarios.isEmpty()){
			return usuarios.get(0);
		}
		
		return null;
		
	}
	


}
