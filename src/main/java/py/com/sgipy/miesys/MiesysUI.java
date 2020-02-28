package py.com.sgipy.miesys;

import javax.servlet.annotation.WebServlet;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import py.com.sgipy.miesys.events.LoginEvent;
import py.com.sgipy.miesys.events.LogoutEvent;
import py.com.sgipy.miesys.events.NavigationEvent;
import py.com.sgipy.miesys.util.UserUtil;
import py.com.sgipy.miesys.view.AltaPersonaView;
import py.com.sgipy.miesys.view.LoginView;
import py.com.sgipy.miesys.view.Main;






/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MiesysUI extends UI {
	
	
	
private EventBus eventBus;
	
	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MiesysUI.class, productionMode = false)
	public static class Servlet extends VaadinServlet {
	}

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	
    	
    	
    	setupEventBus();
    	if (UserUtil.isLoggedIn()){
    			setContent(new Main());
    		} else {
    			setContent(new LoginView());
    		}
     
    	
    }	
    	
    	
    

    private void setupEventBus() {
		eventBus = new EventBus();
		
		eventBus.register(this);
		
	}
	
	public static MiesysUI getCurrent(){
		return (MiesysUI) UI.getCurrent();
	}
	
	@Subscribe
	public void userLoggedIn(LoginEvent event){
		UserUtil.set(event.getUser());
		setContent(new Main());
	}
	
	public static EventBus getEventBus(){
		return getCurrent().eventBus;
		
	}
	public void navigateTo(NavigationEvent view) {
        getNavigator().navigateTo(view.getViewName());
    }
	
	@Subscribe
    public void logout(LogoutEvent logoutEvent) {
        // Don't invalidate the underlying HTTP session if you are using it for something else
        VaadinSession.getCurrent().getSession().invalidate();
        VaadinSession.getCurrent().close();
        Page.getCurrent().reload();

    } 
}
    

