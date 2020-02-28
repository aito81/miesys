package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManagerFactory;

import py.com.sgipy.miesys.controllers.RegionJpaController;

public class JpaRegion extends RegionJpaController{

	public JpaRegion(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}

}
