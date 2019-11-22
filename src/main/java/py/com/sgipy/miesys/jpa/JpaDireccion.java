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
	
	public List<Direccion> findDireccionByPersona(Persona persona, boolean laboral){
		
		EntityManager em = getEntityManager();
		
		List<Direccion> listCiudades = null;
		
		try {
			String sqlQry = " select * from direccion d where d.persona = ?1";
			
			if (laboral) {
				
				sqlQry = sqlQry + " and d.labural = true ";
				
			}else {
			
				sqlQry = sqlQry + " and d.labural = false ";
				
			}
			Query q = em.createNativeQuery(sqlQry, Direccion.class);
			q.setParameter(1, persona.getPersona());
			listCiudades = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al consultar direcciones por persona ", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return listCiudades;
	}

}
