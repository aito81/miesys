package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManagerFactory;

import py.com.sgipy.miesys.controllers.TipoDocumentoJpaController;

public class JpaTipoDocumento extends TipoDocumentoJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaTipoDocumento(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
