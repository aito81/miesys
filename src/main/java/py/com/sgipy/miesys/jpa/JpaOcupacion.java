package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;


import py.com.sgipy.miesys.controllers.OcupacionJpaController;
import py.com.sgipy.miesys.entities.Ocupacion;

public class JpaOcupacion extends OcupacionJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaOcupacion(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public Ocupacion findOcupacionByDesc(String ocupacion){
		
		EntityManager em = getEntityManager();
		
		
		Ocupacion ocBuscada = null;
		try {
			String sqlQry = " select * from ocupacion o where upper(o.descripcion) = upper('"+ ocupacion +"') ";
			Query q = em.createNativeQuery(sqlQry, Ocupacion.class);	
			
			try {
				ocBuscada = (Ocupacion)q.getSingleResult();
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
