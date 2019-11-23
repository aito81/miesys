package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManagerFactory;

import py.com.sgipy.miesys.controllers.ReunionAsistenciaJpaController;

public class JpaReunionAsistencia extends ReunionAsistenciaJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaReunionAsistencia(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
