package br.unipe.javaweb.controleacademico.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.unipe.javaweb.controleacademico.dao.DisciplinaDAO;
import br.unipe.javaweb.controleacademico.model.Disciplina;

public class DisciplinaService {
	static EntityManagerFactory fac  = Persistence.createEntityManagerFactory("controle_academico");
	
	public static void inserir(Disciplina professor){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			DisciplinaDAO dao = new DisciplinaDAO(manager);
			dao.inserir(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static void atualizar(Disciplina professor){

		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			DisciplinaDAO dao = new DisciplinaDAO(manager);
			dao.atualizar(professor);
			manager.getTransaction().commit();
		}catch (Exception e){
			manager.getTransaction().rollback();
		}
		finally{
			manager.close();
		}
	
	}
	
	public static List<Disciplina> listarDisciplinas(){
		EntityManager manager = fac.createEntityManager();
		List<Disciplina> movimentos = new ArrayList<Disciplina>();
		try{
			DisciplinaDAO dao = new DisciplinaDAO(manager);
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

	public static void excluir(Disciplina professor) {
		EntityManager manager = fac.createEntityManager();
		try{
			manager.getTransaction().begin();
			DisciplinaDAO dao = new DisciplinaDAO(manager);
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
	
	public static Disciplina buscarDisciplina(Long id){
		Disciplina movimento = null;
		EntityManager manager = fac.createEntityManager();
		try{
			DisciplinaDAO dao = new DisciplinaDAO(manager);
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
