package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import model.Usuario;

public class Demo08 {
	//  Listado de todos los usuarios segun el tipo de usuario (filtro)
	public static void main(String[] args) {
		String usuario = JOptionPane.showInputDialog("Ingrese su usuario: ");
		String clave = JOptionPane.showInputDialog("Ingrese su clave: ");
		// 1. obtener conexion
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion01");
		// 2. crear manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		// select* from tb_usuarios where idtipo = ?
		String jpql = "select u from Usuario u where u.usr_usua = :xusr and u.cla_usua = :xcla";
		try {
			Usuario u = em.createQuery(jpql, Usuario.class).setParameter("xusr", usuario).setParameter("xcla", clave).getSingleResult();
			
			FrmManteProd v = new FrmManteProd();
			v.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Usuario o clave incorrectas");
		}	
		
		em.close();
	}
}
