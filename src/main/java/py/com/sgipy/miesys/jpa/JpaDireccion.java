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
import py.com.sgipy.miesys.entities.Telefono;


public class JpaDireccion extends DireccionJpaController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaDireccion(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	public List<Direccion> findDireccionByPersona(Persona persona, Boolean laboral){
		
		EntityManager em = getEntityManager();
		
		List<Direccion> listTelefono = null;
		
		try {
			
			String sqlQry =  "select * from direccion t where t.persona = ?1 ";
			
			if (laboral) {
				
				sqlQry = sqlQry + " and t.laboral = true ";
				
			}else {
				
				sqlQry = sqlQry + " and t.laboral = false";
				
			}
			
			Query q = em.createNativeQuery(sqlQry, Direccion.class);
			q.setParameter(1, persona.getPersona());
			
			listTelefono = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al buscar persona", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
	
		return listTelefono;
	
	}

}
