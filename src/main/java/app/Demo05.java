package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
	//  Listado de todos los usuarios
	public static void main(String[] args) {
		// 1. obtener conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		String jpql = "select u from Usuario u";
		List<Usuario> listado = em.createQuery(jpql, Usuario.class).getResultList();
		
			System.out.println("Listado de Usuarios");
		for( Usuario u : listado) {
			System.out.println("Codigo...: "+ u.getCod_usua());
			System.out.println("Nombre...: "+ u.getNom_usua() + " " + u.getApe_usua());
			System.out.println("Tipo...: "+ u.getIdtipo() + " " +  u.getObjTipo().getDescripcion());
			System.out.println("-----------------------------");	
		}
		em.close();
	}
}
