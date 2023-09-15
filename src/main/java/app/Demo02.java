package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	// actualizacion de un usuario
	public static void main(String[] args) {
		// 1. obtener conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		// proceso 
		Usuario u = new Usuario(321, "Clara", "Valac", "ClaVa", "654321", "2002/07/12", 1, 1);
		// insert into tb_xxx values (?,?,?,...
		// ojo!! si el proceso es reg/act/elim se usa trasaccion
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			System.out.println("Registro Ok!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		em.close();
	}
}
