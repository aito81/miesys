package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import py.com.sgipy.miesys.controllers.EstudioJpaController;
import py.com.sgipy.miesys.entities.Estudio;
import py.com.sgipy.miesys.entities.Ocupacion;

public class JpaEstudio extends EstudioJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaEstudio(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	
	public Estudio findEstudioByDesc(String estudio){
		
		EntityManager em = getEntityManager();
		
		
		Estudio ocBuscada = null;
		try {
			String sqlQry = " select * from estudio o where upper(o.descripcion) = upper('"+ estudio +"') ";
			Query q = em.createNativeQuery(sqlQry, Estudio.class);	
			
			try {
				ocBuscada = (Estudio)q.getSingleResult();
			} catch (NoResultException e) {
				// TODO: handle exception
			}
			
			
			
		} catch (Exception e) {
			//Notification.show(e.getMessage() +" Error al buscar persona por numero de documento", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return ocBuscada;
	}

}
