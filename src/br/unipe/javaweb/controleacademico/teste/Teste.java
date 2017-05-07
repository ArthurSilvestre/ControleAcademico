package br.unipe.javaweb.controleacademico.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fac  = Persistence.createEntityManagerFactory("controle_academico");
		@SuppressWarnings("unused")
		EntityManager manager = fac.createEntityManager();
		System.out.println("Finish");
	}

}
