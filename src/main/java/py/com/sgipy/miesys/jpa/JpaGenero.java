package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManagerFactory;

import py.com.sgipy.miesys.controllers.GeneroJpaController;

public class JpaGenero extends GeneroJpaController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaGenero(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
