package br.unipe.javaweb.controleacademico.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.javaweb.controleacademico.dao.CursoDAO;
import br.unipe.javaweb.controleacademico.model.Curso;

public class CursoService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("controle_academico");
	
	public static void inserir(Curso professor){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			CursoDAO dao = new CursoDAO(manager);
			dao.inserir(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void atualizar(Curso professor){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			CursoDAO dao = new CursoDAO(manager);
			dao.atualizar(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static List<Curso> listarCursos(){
		EntityManager manager = fac.createEntityManager();
		List<Curso> movimentos = new ArrayList<Curso>();
		try{
			CursoDAO dao = new CursoDAO(manager);
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

	public static void excluir(Curso professor) {
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			CursoDAO dao = new CursoDAO(manager);
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
	
	public static Curso buscarCurso(Long id){
		Curso movimento = null;
		EntityManager manager = fac.createEntityManager();
		try{
			CursoDAO dao = new CursoDAO(manager);
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
