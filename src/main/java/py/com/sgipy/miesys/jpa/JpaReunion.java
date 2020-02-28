package py.com.sgipy.miesys.jpa;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.ReunionJpaController;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Reunion;

public class JpaReunion extends ReunionJpaController {

	public JpaReunion(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	public List<Reunion> findReunionByFechaAndFecha(Han han, Date fechaDesde, Date fechaHasta){
		
		EntityManager em = getEntityManager();
		
		List<Reunion> listReunion = null;
		
		try {
			
			String sqlQry =  "select * from reunion r where r.han = ?1 and r.fecha BETWEEN ?2 and ?3";
			
			Query q = em.createNativeQuery(sqlQry, Reunion.class);
			q.setParameter(1, han.getHan());
			q.setParameter(2, fechaDesde);
			q.setParameter(3, fechaHasta);
			
			listReunion = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al buscar reuniones por han y fecha", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
	
		return listReunion;
	
	}

}
