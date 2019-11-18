package py.com.sgipy.miesys.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import py.com.sgipy.miesys.controllers.EmpresaJpaController;
import py.com.sgipy.miesys.entities.Empresa;
import py.com.sgipy.miesys.entities.Ocupacion;

public class JpaEmpresa extends EmpresaJpaController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaEmpresa(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Empresa findEmpresaByDesc(String empre){
		
		EntityManager em = getEntityManager();
		
		
		Empresa emBuscada = null;
		try {
			String sqlQry = "select * from empresa e where upper(e.descripcion) = upper('"+ empre +"') ";
			Query q = em.createNativeQuery(sqlQry, Empresa.class);	
			
			try {
				emBuscada = (Empresa)q.getSingleResult();
			} catch (NoResultException e) {
				// TODO: handle exception
			}
			
			
			
		} catch (Exception e) {
			//Notification.show(e.getMessage() +" Error al buscar persona por numero de documento", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return emBuscada;
	}

}
