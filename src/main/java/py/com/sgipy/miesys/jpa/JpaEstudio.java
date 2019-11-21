package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManagerFactory;

import py.com.sgipy.miesys.controllers.EstudioJpaController;

public class JpaEstudio extends EstudioJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaEstudio(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
