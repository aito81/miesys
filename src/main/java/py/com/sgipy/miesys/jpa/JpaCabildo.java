package py.com.sgipy.miesys.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.CabildoJpaController;
import py.com.sgipy.miesys.entities.Cabildo;
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Region;

public class JpaCabildo extends CabildoJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaCabildo(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Cabildo> findCabildoByRegion(Region cab){
		
		EntityManager em = getEntityManager();
		List<Cabildo> listCiudades = null;
		try {
			String sqlQry = " select * from cabildo c where c.region = ?1 ";
			Query q = em.createNativeQuery(sqlQry, Cabildo.class);
			q.setParameter(1, cab.getRegion());
			listCiudades = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al consultar cabildos ", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return listCiudades;
	}

}
