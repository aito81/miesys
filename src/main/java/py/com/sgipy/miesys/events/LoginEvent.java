package py.com.sgipy.miesys.events;

import py.com.sgipy.miesys.entities.Usuario;

public class LoginEvent {
	private Usuario user;
	
	public LoginEvent(Usuario user){
		this.user = user;
	}
	
	public Usuario getUser(){
		return user;
	}

}
