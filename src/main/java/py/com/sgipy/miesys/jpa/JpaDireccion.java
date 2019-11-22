package py.com.sgipy.miesys.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.DireccionJpaController;
import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Departamento;
import py.com.sgipy.miesys.entities.Direccion;
import py.com.sgipy.miesys.entities.Persona;


public class JpaDireccion extends DireccionJpaController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaDireccion(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	public Direccion findDireccionByPersona(Persona persona, boolean laboral){
		
		EntityManager em = getEntityManager();
		
		Direccion cargoPre = null;
		
		try {
			
			String sqlQry =  "select * from direccion d where d.persona = ?1 ";
			
			if (laboral) {
				
				sqlQry = sqlQry + " and d.laboral = true ";
				
			}else {
				
				sqlQry = sqlQry + " and d.laboral = false";
				
			}
			Query q = em.createNativeQuery(sqlQry, Direccion.class);
			
			q.setParameter(1, persona.getPersona());
			
			cargoPre = (Direccion)q.getSingleResult();
			
		} catch (NullPointerException e) {
			
			Notification.show(e.getMessage() +" Error al buscar direccion por persona.", Notification.TYPE_ERROR_MESSAGE );
			
		}finally {
			
			em.close();
		}
		
		
		return cargoPre;
	}

}
