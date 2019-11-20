package py.com.sgipy.miesys.view;

import java.io.File;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.themes.ValoTheme;

import py.com.sgipy.miesys.events.EventBus;
import py.com.sgipy.miesys.jpa.JpaUsuario;
import py.com.sgipy.miesys.util.JpaUtil;
import py.com.sgipy.miesys.util.UserUtil;



/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class LoginView extends CustomComponent {
	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private VerticalLayout loginLayout;
	@AutoGenerated
	private LoginForm loginEva;
	
	private HorizontalLayout maquetaLayout;
	private VerticalLayout logoLayout;
	private HorizontalLayout logueoLayout;
	private Window window;
	
	private TextField txtUsuario;
	private PasswordField txtpass;
	
	private Button btnIngresar;
	
	private Image imagen;

	private JpaUsuario jpaUsuario = new JpaUsuario(JpaUtil.getEntityManagerFactory());
	
	public LoginView() {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		//loginEva.setUsernameCaption("Funcionario");
		//loginEva.setPasswordCaption("Constraseña");
		
		//loginEva.addLoginListener(event -> loggear(event));
		
		btnIngresar.addClickListener(e -> ingresar(txtUsuario.getValue(), txtpass.getValue()));
		
		txtUsuario.focus();
		
		//imagen.setSource(new ThemeResource("images/cabeceraImagen.png"));
		
		//txtUsuario.addBlurListener(e -> buscarFoto() );
		
		
	}
	/*private void buscarFoto() {
		
		Usuario usuFoto = jpaUsuario.findUsuarioByUser(txtUsuario.getValue());
		if (usuFoto != null) {
			
			if (usuFoto.getPersona() != null) {
				
				File arch = new File(usuFoto.getPersona().getFoto());
				
				imagen.setSource(new FileResource(arch));
				
			}else {
				
				imagen.setSource(new ThemeResource("images/cabeceraImagen.png"));
				
			}
			
			
		}else {
			
			imagen.setSource(new ThemeResource("images/cabeceraImagen.png"));
			
		}
		
	}*/
	private void ingresar(String usuario, String clave) {
		
		String pass;
		String user;
		boolean ingresar;
		
		//pass = evento.getLoginParameter("password").toString();
		//user = evento.getLoginParameter("username").toString();
		
		pass = clave;
		user = usuario;
		
		
		if (pass == "") {
			Notification.show("Debe ingresar la contraseña", Notification.Type.ERROR_MESSAGE);
			return;
		}
		
		if (user == "") {
			Notification.show("Debe ingresar el usuario", Notification.Type.ERROR_MESSAGE);
			return;
		}
		
		ingresar = jpaUsuario.login(user, pass);
		if (ingresar) {
			
		/*	//Notification.show("Adelante");
			FuncionariosView funView = new FuncionariosView();
			Window ventana = new Window("Funcionarios", funView);
			ventana.center();
			ventana.setResizable(true);
			ventana.setModal(true);
			UI.getCurrent().addWindow(ventana);*/
			//EventBus.post(new py.com.tipcsa.eva.event.LoginEvent(jpaUsuario.findUsuario(5)));
			//EventBus.post(new py.com.tipcsa.eva.event.LoginEvent());
			EventBus.post(new py.com.sgipy.miesys.events.LoginEvent(jpaUsuario.findUsuarioByUser(user)));
			UserUtil.set(jpaUsuario.findUsuarioByUser(user));
			UserUtil.setUsuario(jpaUsuario.findUsuarioByUser(user));
			//  EventBus.post(py.com.tipcsa.eva.event.LoginEvent(jpaUsuario.findUsuarioByUser(user)));
			//EvaUI.getCurrent().getNavigator().navigateTo("");
			
			
		}else {
			Notification.show("Usuario o contraseña incorrectos", Notification.Type.ERROR_MESSAGE);
		}
		
		
		
	}
	private void loggear(LoginEvent evento) {
	
		
		String pass;
		String user;
		boolean ingresar;
		
		pass = evento.getLoginParameter("password").toString();
		user = evento.getLoginParameter("username").toString();
		
		if (pass == "") {
			Notification.show("Debe ingresar la contraseña", Notification.Type.ERROR_MESSAGE);
			return;
		}
		
		if (user == "") {
			Notification.show("Debe ingresar el usuario", Notification.Type.ERROR_MESSAGE);
			return;
		}
		
		ingresar = jpaUsuario.login(user, pass);
		if (ingresar) {
			
		/*	//Notification.show("Adelante");
			FuncionariosView funView = new FuncionariosView();
			Window ventana = new Window("Funcionarios", funView);
			ventana.center();
			ventana.setResizable(true);
			ventana.setModal(true);
			UI.getCurrent().addWindow(ventana);*/
			//EventBus.post(new py.com.tipcsa.eva.event.LoginEvent(jpaUsuario.findUsuario(5)));
			//EventBus.post(new py.com.tipcsa.eva.event.LoginEvent());
			EventBus.post(new py.com.sgipy.miesys.events.LoginEvent(jpaUsuario.findUsuarioByUser(user)));
			UserUtil.set(jpaUsuario.findUsuarioByUser(user));
			UserUtil.setUsuario(jpaUsuario.findUsuarioByUser(user));
			//  EventBus.post(py.com.tipcsa.eva.event.LoginEvent(jpaUsuario.findUsuarioByUser(user)));
			//EvaUI.getCurrent().getNavigator().navigateTo("");
			
			
		}else {
			Notification.show("Usuario o contraseña incorrectos", Notification.Type.ERROR_MESSAGE);
		}
		
		
		
		
		
		
		
	}
	
	
	public void setWindow(Window window){
		this.window = window;
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		//mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100%");
		
		// loginLayout
		loginLayout = buildLoginLayout();
		mainLayout.addComponent(loginLayout);
		mainLayout.setComponentAlignment(loginLayout, Alignment.MIDDLE_CENTER);
		
		
		/*mainLayout.setComponentAlignment(loginLayout, Alignment.MIDDLE_CENTER);
		mainLayout.setComponentAlignment(loginLayout, new Alignment(50));*/
		
		
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildLoginLayout() {
		// common part: create layout
		loginLayout = new VerticalLayout();
		//loginLayout.setImmediate(false);
		loginLayout.setWidth("100%");
		loginLayout.setHeight("100%");
		loginLayout.setMargin(false);
		
		maquetaLayout = buildMaquetaLayout();
		loginLayout.addComponent(maquetaLayout);
		loginLayout.setComponentAlignment(maquetaLayout, Alignment.MIDDLE_CENTER);
		
		// login
		//loginEva = new LoginForm();
	//	loginEva.setStyleName("v-loginform");
		//loginAysa.setImmediate(false);
		//loginEva.setWidth("50%");
		//loginEva.setHeight("50%");
		
		
		//loginLayout.addComponent(loginEva);
		//loginLayout.setComponentAlignment(loginEva, new Alignment(48));
		//loginLayout.setComponentAlignment(loginEva, Alignment.BOTTOM_LEFT);
		
		return loginLayout;
	}
	private HorizontalLayout buildMaquetaLayout() {
		
		maquetaLayout = new HorizontalLayout();
		maquetaLayout.setMargin(false);
		
		logoLayout = BuildLogoLayout();
		maquetaLayout.addComponent(logoLayout);
		
		logueoLayout = buildLogueoLayout();
		maquetaLayout.addComponent(logueoLayout);
		
		return maquetaLayout;
	}
	private HorizontalLayout buildLogueoLayout() {
		
		logueoLayout = new HorizontalLayout();
		logueoLayout.setMargin(false);
		logueoLayout.setWidth("50%");
		
		imagen = new Image();
		imagen.setWidth("150px");
		imagen.setHeight("150px");
		//logueoLayout.addComponent(imagen);
		
		
		txtUsuario = new TextField();
		txtUsuario.setCaption("Funcionario");
		logueoLayout.addComponent(txtUsuario);
		
		txtpass = new PasswordField();
		txtpass.setCaption("Clave");
		logueoLayout.addComponent(txtpass);
		
		btnIngresar = new Button();
		btnIngresar.setCaption("Ingresar");
		btnIngresar.setStyleName(ValoTheme.BUTTON_DANGER);
		logueoLayout.addComponent(btnIngresar);
		logueoLayout.setComponentAlignment(btnIngresar, Alignment.BOTTOM_CENTER);
		
		logueoLayout.setStyleName("v-loginform");
		
		return logueoLayout;
	}
	private VerticalLayout BuildLogoLayout() {
		
		logoLayout = new VerticalLayout();
		logoLayout.setMargin(false);
		logoLayout.setWidth("50%");
		
		
		return logoLayout;
	}

	
	
	
	
	
	
	
	
	
	
}
