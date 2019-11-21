package py.com.sgipy.miesys.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.PersonaJpaController;
import py.com.sgipy.miesys.entities.Division;
import py.com.sgipy.miesys.entities.Genero;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Nacionalidad;
import py.com.sgipy.miesys.entities.Persona;

public class JpaPersona extends PersonaJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaPersona(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Persona> findPersonaByParam(String busqueda, Division div, Nacionalidad nac, Han han, Genero gen){
		
		EntityManager em = getEntityManager();
		
		List<Persona> listPersona = null;
		
		try {
			
			String sqlQry = " select * from persona p where p.persona > 0 ";
			
			if (!busqueda.isEmpty()) {
				
				String buscar = "'%" + busqueda + "%'";
				
				sqlQry = sqlQry + " and upper(p.nombre || p.apellido) like upper("+ buscar+ ")";
				
			}
			
			if (div != null) {
				
				sqlQry = sqlQry+ " and p.division = " + div.getDivision().toString();
				
			}
			
			if (nac != null) {
				
				sqlQry = sqlQry + " and p.nacionalidad = "+ nac.getNacionalidad().toString();
				
			}
			
			if (han != null) {
				
				sqlQry = sqlQry + " and p.han = " + han.getHan().toString();
				
			}
			
			if (gen != null) {
				
				sqlQry = sqlQry + " and p.genero = " + gen.getGenero().toString();
			}
			
			Query q = em.createNativeQuery(sqlQry, Persona.class);
			listPersona = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al buscar persona", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
	
		return listPersona;
	
	}

}
