package py.com.sgipy.miesys.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.DistritoJpaController;
import py.com.sgipy.miesys.entities.Cabildo;
import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Departamento;
import py.com.sgipy.miesys.entities.Distrito;

public class JpaDistrito extends DistritoJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaDistrito(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Distrito> findDistritoByCabildo(Cabildo cab){
		
		EntityManager em = getEntityManager();
		List<Distrito> listCiudades = null;
		try {
			String sqlQry = " select * from distrito d where d.cabildo = ?1 ";
			Query q = em.createNativeQuery(sqlQry, Distrito.class);
			q.setParameter(1, cab.getCabildo());
			listCiudades = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al consultar distritos ", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return listCiudades;
	}

}
