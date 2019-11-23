package py.com.sgipy.miesys.view;

import java.text.SimpleDateFormat;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.ItemClick;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.components.grid.ItemClickListener;
import com.vaadin.ui.renderers.HtmlRenderer;

import py.com.sgipy.miesys.MiesysUI;
import py.com.sgipy.miesys.entities.Division;
import py.com.sgipy.miesys.entities.Genero;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Nacionalidad;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.jpa.JpaDivision;
import py.com.sgipy.miesys.jpa.JpaGenero;
import py.com.sgipy.miesys.jpa.JpaHan;
import py.com.sgipy.miesys.jpa.JpaNacionalidad;
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
	
	private ComboBox<Han> cbxHan;
	private ComboBox<Genero> cbxGenero;
	private ComboBox<Nacionalidad> cbxNacionalidad;
	private ComboBox<Division> cbxDivision;
	
	private Button btnSalir;
	private Button btnBuscar;
	
	private JpaPersona jpaPer = new JpaPersona(JpaUtil.getEntityManagerFactory());
	private JpaHan jpaHan = new JpaHan(JpaUtil.getEntityManagerFactory());
	private JpaNacionalidad jpaNac = new JpaNacionalidad(JpaUtil.getEntityManagerFactory());
	private JpaGenero jpaGen = new JpaGenero(JpaUtil.getEntityManagerFactory());
	private JpaDivision jpaDiv = new JpaDivision(JpaUtil.getEntityManagerFactory());
	
	private Window ventana;
	
	
	public PersonaAbmView () {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		cargarGrilla();
		btnSalir.addClickListener(e -> volver());
		//txtBusqueda.addValueChangeListener(e -> buscar(e.getValue()));
		btnBuscar.addClickListener(e -> gridPersona.setItems(
				jpaPer.findPersonaByParam(txtBusqueda.getValue(), cbxDivision.getValue(), cbxNacionalidad.getValue(), cbxHan.getValue(), cbxGenero.getValue())));
		cargarCombos();
		
	}


	


	private void cargarCombos() {
		
		cbxGenero.setItems(jpaGen.findGeneroEntities());
		cbxGenero.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		cbxHan.setItems(jpaHan.findHanEntities());
		cbxHan.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		cbxNacionalidad.setItems(jpaNac.findNacionalidadEntities());
		cbxNacionalidad.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		cbxDivision.setItems(jpaDiv.findDivisionEntities());
		cbxDivision.setItemCaptionGenerator(gen -> gen.getDescripcion());
	
		
	}




	private void volver() {
		
		MiesysUI.getCurrent().getNavigator().navigateTo("");
	}


	private void cargarGrilla() {
		
		gridPersona.setItems(jpaPer.findPersonaEntities());
		gridPersona.addColumn(persona -> persona.getNombre()).setId("nombre").setCaption("Nombre");
		gridPersona.addColumn(Persona::getApellido).setId("apellido").setCaption("Apellido");
		gridPersona.addColumn(persona -> persona.getNumeroDocumento()).setId("nroDoc").setCaption("Numero Documento");
		gridPersona.addColumn(persona -> persona.getHan().getDescripcion()).setId("han").setCaption("Han");
		
		
		gridPersona.addColumn(persona ->{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			return sdf.format(persona.getFechaNacimiento());
		}).setId("fechaNac").setCaption("Fecha Nacimiento");
		
		gridPersona.addColumn(Persona -> FontAwesome.EYE.getHtml(), 
				new HtmlRenderer()).setId("ver").setStyleGenerator(matriz ->
				"align-center").setWidth(70).setCaption("Ver");
		
		gridPersona.addColumn(Persona -> FontAwesome.EDIT.getHtml(),
				new HtmlRenderer()).setId("editar").setStyleGenerator(matriz ->
		"align-center").setWidth(70).setCaption("Editar");
		
		gridPersona.getDefaultHeaderRow().join("ver","editar").setText("Opciones");
		
		gridPersona.addItemClickListener(new ItemClickListener<Persona>() {

			@Override
			public void itemClick(ItemClick<Persona> event) {

				if (event.getColumn().getId().equals("ver")) {
					verPersona(event.getItem());
				}
				
				if (event.getColumn().getId().equals("editar")) {
					editarPersona(event.getItem());
				}
				
			}
		});
		
	}
	
	private void verPersona(Persona per) {
		AltaPersonaView editPersona = new AltaPersonaView(per);
		ventana = new Window("Consulta de Datos", editPersona);
		ventana.center();
		ventana.setSizeFull();
		//editPersona.getAltaLayout().setEnabled(false);
		//editPersona.getMainLayout().setEnabled(false);
		editPersona.getBotonLayout().setVisible(false);
		editPersona.getFormLayout().setEnabled(false);
		
		UI.getCurrent().addWindow(ventana);
		//ventana.addCloseListener(e -> gridPersona.setItems(jpaPer.findPersonasActiva()));
		
	}
	
	private void editarPersona(Persona per) {
		AltaPersonaView editPersona = new AltaPersonaView(per);
		ventana = new Window("Consulta de Datos", editPersona);
		ventana.center();
		ventana.setSizeFull();
		
		UI.getCurrent().addWindow(ventana);
		ventana.addCloseListener(e -> gridPersona.setItems(jpaPer.findPersonaEntities()));
		
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
		formLayout.setComponentAlignment(busquedaLayout, Alignment.MIDDLE_CENTER);
		
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
		busquedaLayout.setCaption("Busqueda");
		
		cbxGenero = new ComboBox<Genero>();
		cbxGenero.setCaption("Genero");
		busquedaLayout.addComponent(cbxGenero);
		
		cbxNacionalidad = new ComboBox<Nacionalidad>();
		cbxNacionalidad.setCaption("Nacionalidad");
		busquedaLayout.addComponent(cbxNacionalidad);
		
		cbxHan = new ComboBox<Han>();
		cbxHan.setCaption("Han");
		busquedaLayout.addComponent(cbxHan);
		
		cbxDivision = new ComboBox<Division>();
		cbxDivision.setCaption("Division");
		busquedaLayout.addComponent(cbxDivision);
		
		txtBusqueda = new TextField();
		txtBusqueda.setCaption("Nombre y/o apellido");
		busquedaLayout.addComponent(txtBusqueda);
		
		btnBuscar = new Button();
		btnBuscar.setCaption("Buscar");
		busquedaLayout.addComponent(btnBuscar);
		busquedaLayout.setComponentAlignment(btnBuscar, Alignment.BOTTOM_CENTER);
		
		return busquedaLayout;
	}

}
