package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManagerFactory;

import py.com.sgipy.miesys.controllers.TenenciaJpaController;

public class JpaTenencia extends TenenciaJpaController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaTenencia(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
