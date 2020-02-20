package py.com.sgipy.miesys.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.BarrioJpaController;
import py.com.sgipy.miesys.entities.Barrio;
import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Departamento;

public class JpaBarrio extends BarrioJpaController {

	public JpaBarrio(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	public List<Barrio> findBarriobyCiudad(Ciudad depto){
		
		EntityManager em = getEntityManager();
		List<Barrio> listCiudades = null;
		try {
			String sqlQry = " select * from barrio c where c.ciudad = ?1";
			Query q = em.createNativeQuery(sqlQry, Ciudad.class);
			q.setParameter(1, depto.getCiudad());
			listCiudades = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al consultar barrios ", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return listCiudades;
	}

}
