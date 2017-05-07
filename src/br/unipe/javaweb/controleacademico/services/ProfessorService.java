package br.unipe.javaweb.controleacademico.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.javaweb.controleacademico.dao.ProfessorDAO;
import br.unipe.javaweb.controleacademico.model.Professor;

public class ProfessorService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("controle_academico");
	
	public static void inserir(Professor professor){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			ProfessorDAO dao = new ProfessorDAO(manager);
			dao.inserir(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void atualizar(Professor professor){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			ProfessorDAO dao = new ProfessorDAO(manager);
			dao.atualizar(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static List<Professor> listarProfessores(){
		EntityManager manager = fac.createEntityManager();
		List<Professor> movimentos = new ArrayList<Professor>();
		try{
			ProfessorDAO dao = new ProfessorDAO(manager);
			movimentos = dao.listar();
		}catch (Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
		}
		return movimentos;
	
	}

	public static void excluir(Professor professor) {
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			ProfessorDAO dao = new ProfessorDAO(manager);
			dao.excluir(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			e.printStackTrace();
			manager.getTransaction().rollback();
			
		}
		finally{
			manager.close();
		}
	}
	
	public static Professor buscarProfessor(Long id){
		Professor movimento = null;
		EntityManager manager = fac.createEntityManager();
		try{
			ProfessorDAO dao = new ProfessorDAO(manager);
			movimento = dao.buscarPorId(id);
		}catch (Exception e){
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
		}
		return movimento;
	
	}

}
