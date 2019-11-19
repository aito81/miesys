package py.com.sgipy.miesys.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.HanJpaController;
import py.com.sgipy.miesys.entities.Cabildo;
import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Han;

public class JpaHan extends HanJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaHan(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public List<Han> findHanByDistrito(Distrito dis){
		
		EntityManager em = getEntityManager();
		List<Han> listCiudades = null;
		try {
			String sqlQry = " select * from han h where h.distrito = ?1  ";
			Query q = em.createNativeQuery(sqlQry, Han.class);
			q.setParameter(1, dis.getDistrito());
			listCiudades = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al consultar hanes ", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return listCiudades;
	}

}
