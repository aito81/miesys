package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManagerFactory;

import py.com.sgipy.miesys.controllers.PersonaJpaController;

public class JpaPersona extends PersonaJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaPersona(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
