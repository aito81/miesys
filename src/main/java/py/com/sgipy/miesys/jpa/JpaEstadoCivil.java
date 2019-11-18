package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManagerFactory;

import py.com.sgipy.miesys.controllers.EstadoCivilJpaController;

public class JpaEstadoCivil extends EstadoCivilJpaController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaEstadoCivil(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
