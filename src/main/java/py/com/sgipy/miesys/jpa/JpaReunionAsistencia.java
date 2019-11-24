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

public class JpaReunionAsistencia extends ReunionAsistenciaJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaReunionAsistencia(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	//select * from reunion_asistencia ra where ra.reunion = 18
	
	

}
