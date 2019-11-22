package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.TelefonoJpaController;
import py.com.sgipy.miesys.entities.Direccion;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.Telefono;

public class JpaTelefono extends TelefonoJpaController{

	public JpaTelefono(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	public Telefono findTelefonoByPersona(Persona persona, boolean laboral){
		
		EntityManager em = getEntityManager();
		
		Telefono cargoPre = null;
		
		try {
			
			String sqlQry =  "select * from telefono t where t.persona = ?1 ";
			
			if (laboral) {
				
				sqlQry = sqlQry + " and t.laboral = true ";
				
			}else {
				
				sqlQry = sqlQry + " and t.laboral = false";
				
			}
			Query q = em.createNativeQuery(sqlQry, Telefono.class);
			
			q.setParameter(1, persona.getPersona());
			
			cargoPre = (Telefono)q.getSingleResult();
			
		} catch (NullPointerException e) {
			
			Notification.show(e.getMessage() +" Error al buscar telefono por persona.", Notification.TYPE_ERROR_MESSAGE );
			
		}finally {
			
			em.close();
		}
		
		
		return cargoPre;
	}

}
