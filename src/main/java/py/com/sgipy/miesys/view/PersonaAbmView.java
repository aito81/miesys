package py.com.sgipy.miesys.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import py.com.sgipy.miesys.MiesysUI;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.jpa.JpaPersona;
import py.com.sgipy.miesys.util.JpaUtil;
import py.com.sgipy.miesys.util.ViewConfig;






@ViewConfig(uri = "personaConsulta", displayName = "persona")
public class PersonaAbmView extends CustomComponent implements View {
	
	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private HorizontalLayout busquedaLayout;
	private VerticalLayout datosLayout;
	private HorizontalLayout botonLayout;
	
	private TextField txtBusqueda;
	
	private Grid<Persona> gridPersona;
	
	private Button btnSalir;
	
	private JpaPersona jpaPer = new JpaPersona(JpaUtil.getEntityManagerFactory());
	
	
	public PersonaAbmView () {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		cargarGrilla();
		btnSalir.addClickListener(e -> volver());
	}


	private void volver() {
		
		MiesysUI.getCurrent().getNavigator().navigateTo("");
	}


	private void cargarGrilla() {
		
		gridPersona.setItems(jpaPer.findPersonaEntities());
		gridPersona.addColumn(persona -> persona.getNombre()).setId("nombre").setCaption("Nombre");
		gridPersona.addColumn(persona -> persona.getApellido()).setId("apellido").setCaption("Apellido");
		gridPersona.addColumn(persona -> persona.getNumeroDocumento()).setId("nroDoc").setCaption("Numero Documento");
		gridPersona.addColumn(persona -> persona.getHan().getDescripcion()).setId("han").setCaption("Han");
		gridPersona.addColumn(persona -> persona.getFechaNacimiento()).setId("fechaNac").setCaption("Fecha Nacimiento");
		
	}
	


	private void buildMainLayout() {

		mainLayout = new VerticalLayout();
		mainLayout.setWidth("70%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		setWidth("100%");
		setHeight("-1px");
		
		formLayout = buildFormLayout();
		mainLayout.addComponent(formLayout);
		
	}


	private VerticalLayout buildFormLayout() {

		formLayout = new VerticalLayout();
		formLayout.setHeight("-1px");
		formLayout.setWidth("100%");
		//formLayout.setSpacing(false);
		formLayout.setMargin(false);
		
		busquedaLayout = buildBusquedaLayout();
		formLayout.addComponent(busquedaLayout);
		
		datosLayout = buildDatosLayout();
		formLayout.addComponent(datosLayout);
		
		botonLayout = buildBotonLayout();
		formLayout.addComponent(botonLayout);
		
		
		
		return formLayout;
	}


	private HorizontalLayout buildBotonLayout() {
		
		botonLayout = new HorizontalLayout();
		
		btnSalir = new Button();
		btnSalir.setCaption("Salir");
		botonLayout.addComponent(btnSalir);
		
		
		
		return botonLayout;
	}


	private VerticalLayout buildDatosLayout() {
		
		datosLayout = new VerticalLayout();
		datosLayout.setWidth("100%");
		datosLayout.setSpacing(false);
		datosLayout.setMargin(false);
		
		gridPersona = new Grid<Persona>();
		gridPersona.setWidth("100%");
		
		datosLayout.addComponent(gridPersona);
		return datosLayout;
	}


	private HorizontalLayout buildBusquedaLayout() {

		busquedaLayout = new HorizontalLayout();
		
		txtBusqueda = new TextField();
		txtBusqueda.setCaption("Busqueda");
		busquedaLayout.addComponent(txtBusqueda);
		
		return busquedaLayout;
	}

}
