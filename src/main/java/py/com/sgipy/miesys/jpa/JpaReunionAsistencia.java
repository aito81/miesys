package py.com.sgipy.miesys.jpa;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.ReunionAsistenciaJpaController;
import py.com.sgipy.miesys.entities.Direccion;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.Reunion;
import py.com.sgipy.miesys.entities.ReunionAsistencia;

public class JpaReunionAsistencia extends ReunionAsistenciaJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;

	public JpaReunionAsistencia(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	//delete from reunion_asistencia ra where ra.reunion_asistencia =
	
	public void DeleteReunionAsistenciaById(ReunionAsistencia reuAsi){
		
		EntityManager em = getEntityManager();
		
		
		try {
			
			String sqlQry =  "delete from reunion_asistencia ra where ra.reunion_asistencia = ?1";
			
			Query q = em.createNativeQuery(sqlQry, ReunionAsistencia.class);
			q.setParameter(1, ReunionAsistencia.class);
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al borrar asistente.", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
	
	}
	
	
	 
	    public void delete(ReunionAsistencia artist) {
	    	
	        manager.getTransaction().begin();
	        manager.remove(artist);
	        manager.getTransaction().commit();
	    }
	

}
