package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo09 {
	//  Listado de todos los usuarios segun el tipo de usuario (filtro)
	public static void main(String[] args) {
		// 1. obtener conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// select* from tb_usuarios where idtipo = ?
		String jpql = "select u from Usuario u where u.nom_usua = :xnom and u.cla_usua = :xcla";
		List<Usuario> listado = em.createQuery(jpql, Usuario.class).setParameter("xnom", "Tito").setParameter("xcla","10001").getResultList();
		
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
