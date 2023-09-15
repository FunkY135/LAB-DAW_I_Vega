package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {
	// registro de un usuario
	public static void main(String[] args) {
		// 1. obtener conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		// proceso 
		Usuario u = new Usuario(321, "Clara", "Valac", "farfal", "123456", "2001/06/11", 1, 1);
		// insert into tb_xxx values (?,?,?,...
		// ojo!! si el proceso es reg/act/elim se usa trasaccion
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
			System.out.println("Registro Ok!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
	}
}
