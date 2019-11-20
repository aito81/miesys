package py.com.sgipy.miesys.util;

import com.vaadin.server.VaadinSession;

import py.com.sgipy.miesys.entities.Usuario;
import py.com.sgipy.miesys.jpa.JpaUsuario;


public class UserUtil {
	
	private static final String KEY = "currentuser";
	private static JpaUsuario jpaUsuario = new JpaUsuario(JpaUtil.getEntityManagerFactory());
	
	public static void setUsuario(Usuario user) {
        VaadinSession.getCurrent().setAttribute(KEY, user);
	}
	
	public static Usuario getUsuario() {
    	return (Usuario) VaadinSession.getCurrent().getAttribute(KEY); 
    }
	
	public static void set(Usuario user) {
        VaadinSession.getCurrent().setAttribute(KEY, user);
    }
	
	public static boolean isLoggedIn() {
        return getUsuario() != null;
    }

}
