package br.unipe.javaweb.controleacademico.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.javaweb.controleacademico.dao.UsuarioDAO;
import br.unipe.javaweb.controleacademico.model.Usuario;

public class UsuarioService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("controle_academico");
	
	public static Usuario efetuarLogin(String login, String senha){

		EntityManager manager = fac.createEntityManager();
		Usuario usuario = null;
		try{
			UsuarioDAO dao = new UsuarioDAO(manager);
			usuario = dao.efetuaLogin(login, senha);
		}
		finally{
			manager.close();
		}
		return usuario;
	
	}
	
	
}
