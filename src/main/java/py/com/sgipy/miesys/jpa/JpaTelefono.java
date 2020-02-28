package py.com.sgipy.miesys.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.TelefonoJpaController;
import py.com.sgipy.miesys.entities.Direccion;
import py.com.sgipy.miesys.entities.Division;
import py.com.sgipy.miesys.entities.Genero;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Nacionalidad;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.Telefono;

public class JpaTelefono extends TelefonoJpaController{

	public JpaTelefono(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public List<Telefono> findTelefonoByPersona(Persona persona, Boolean laboral){
		
		EntityManager em = getEntityManager();
		
		List<Telefono> listTelefono = null;
		
		try {
			
			String sqlQry =  "select * from telefono t where t.persona = ?1 ";
			
			if (laboral) {
				
				sqlQry = sqlQry + " and t.laboral = true ";
				
			}else {
				
				sqlQry = sqlQry + " and t.laboral = false";
				
			}
			
			Query q = em.createNativeQuery(sqlQry, Telefono.class);
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
