package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Productos;

public class Demo06 {
	//  Listado de todos los usuarios
	public static void main(String[] args) {
		// 1. obtener conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		String jpql = "select p from Productos p";
		List<Productos> listado = em.createQuery(jpql, Productos.class).getResultList();
		
			System.out.println("Listado de Productos");
		for( Productos p : listado) {
			System.out.println("ID...: "+ p.getId_prod());
			System.out.println("Descripcion...: "+ p.getDes_prod());
			System.out.println("Stock...: " + p.getStk_prod());
			System.out.println("Precio...: " + p.getPre_prod());
			System.out.println("Categoria...: " + p.getObjCategorias().getDescripcion());
			System.out.println("Estado...: " + p.getEst_prod());
			System.out.println("Proveedor...: " + p.getObjProveedor().getNombre_rs());
			System.out.println("-----------------------------");	
		}
		em.close();
	}
}
