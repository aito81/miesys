package py.com.sgipy.miesys.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.vaadin.ui.Notification;

import py.com.sgipy.miesys.controllers.HanJpaController;
import py.com.sgipy.miesys.entities.Cabildo;
import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Ocupacion;
import py.com.sgipy.miesys.entities.Region;

public class JpaHan extends HanJpaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JpaHan(EntityManagerFactory emf) {
		super(emf);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public List<Han> findHanByDistrito(Distrito dis){
		
		EntityManager em = getEntityManager();
		List<Han> listCiudades = null;
		try {
			String sqlQry = " select * from han h where h.distrito = ?1  ";
			Query q = em.createNativeQuery(sqlQry, Han.class);
			q.setParameter(1, dis.getDistrito());
			listCiudades = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al consultar hanes ", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return listCiudades;
	}
	
	
	public Han findHanRepetido(String han) {
		
		EntityManager em = getEntityManager();
		
		Han repetido = null;
		
		try {
			
			String sqlQry = " select * from han h where upper(o.descripcion) = upper('"+han +"') ";
			Query q = em.createNativeQuery(sqlQry, Ocupacion.class);	
			
			try {
				repetido = (Han)q.getSingleResult();
			} catch (NoResultException e) {
				// TODO: handle exception
			}
			
			
			
		} catch (Exception e) {
			//Notification.show(e.getMessage() +" Error al buscar persona por numero de documento", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return repetido;
		
	}
	

	
	
	public List<Han> findHanByParamaters(Region reg, Cabildo cab, Distrito dis, String han){
		
		EntityManager em = getEntityManager();
		List<Han> listHan = null;
		try {
			String sqlQry = " select * from han h  ";
			
			if (dis != null) {
				
				sqlQry = sqlQry + " inner join distrito d on d.distrito = "+ dis.getDistrito();
				
			}else {
				
				sqlQry = sqlQry + "inner join distrito d on d.distrito = h.distrito ";
			}
			
			if (cab != null) {
				
				sqlQry = sqlQry + " inner join cabildo c on c.cabildo = " + cab.getCabildo();
				
			}else {
				
				sqlQry = sqlQry + " inner join cabildo c on c.cabildo = d.cabildo ";
			}
			
			if (reg != null) {
			
				sqlQry = sqlQry+" inner join region r on r.region = " + reg.getRegion();
				
			}else {
				
				sqlQry = sqlQry+ " inner join region r on r.region = c.region "; 
			}
			
			
			
			if (!han.isEmpty()) {
				
				han = "'%"+ han +"%'";
				
				sqlQry = sqlQry + " where upper(h.descripcion) like upper("+ han + ") ";
				
			}
			
			Query q = em.createNativeQuery(sqlQry, Han.class);
			listHan = q.getResultList();
		} catch (Exception e) {
			Notification.show(e.getMessage() +" Error al consultar hanes ", Notification.TYPE_ERROR_MESSAGE );
		}finally {
			em.close();
		}
		
		
		return listHan;
	}
	
	
	
	
	/*
	 * select * from han h 
inner join distrito d on d.distrito = h.distrito
inner join cabildo c on c.cabildo = d.cabildo
where h.han like ('% %')
	 */
	
	
	

}
