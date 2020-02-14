package py.com.sgipy.miesys.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import py.com.sgipy.miesys.entities.Cabildo;
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.Region;
import py.com.sgipy.miesys.jpa.JpaCabildo;
import py.com.sgipy.miesys.jpa.JpaDistrito;
import py.com.sgipy.miesys.jpa.JpaHan;
import py.com.sgipy.miesys.jpa.JpaPersona;
import py.com.sgipy.miesys.jpa.JpaRegion;
import py.com.sgipy.miesys.util.Funciones;
import py.com.sgipy.miesys.util.JpaUtil;
import py.com.sgipy.miesys.util.ViewConfig;

@ViewConfig(uri = "hanPersona", displayName = "Integrantes de Han")
public class PersonaHanView extends CustomComponent implements View {

	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private HorizontalLayout cabeceraLayout;
	private HorizontalLayout datosLayout;
	private HorizontalLayout botonLayout;
	
	private ComboBox<Region> cbxRegion;
	private ComboBox<Cabildo> cbxCabildo;
	private ComboBox<Distrito> cbxDistrito;
	private ComboBox<Han> cbxHan;
	
	private Grid<Persona> gridPersona;
	private Grid<Persona> gridMiembro;
	
	private TextField txtBusqueda;
	
	private Button btnGuardar;
	private Button btnSalir;
	
	private JpaRegion jpaRegion = new JpaRegion(JpaUtil.getEntityManagerFactory());
	private JpaCabildo jpaCabildo = new JpaCabildo(JpaUtil.getEntityManagerFactory());
	private JpaDistrito jpaDistrito = new JpaDistrito(JpaUtil.getEntityManagerFactory());
	private JpaHan jpaHan = new JpaHan(JpaUtil.getEntityManagerFactory());
	private JpaPersona jpaPersona = new JpaPersona(JpaUtil.getEntityManagerFactory());
	
	
	
	public PersonaHanView() {
		
		buildMainLayout();
		
		setCompositionRoot(mainLayout);
		
		cargarCombos();
		
		crearGrillaPersona();
		
		crearGrillaMiembro();
		
		txtBusqueda.addValueChangeListener(e -> buscarPersona(e.getValue()));
		
		btnSalir.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {

				Funciones.salir();
				
			}
		});
		
		gridMiembro.addItemClickListener(e -> cambiarPersona(e.getItem()));
		
		
		
	}

	private void cambiarPersona(Persona item) {
		
		if (item == null) {
			
			return;
			
		}
		
		
		
	}

	private void buscarPersona(String value) {
		
		if ((value.isEmpty()) || (value == null)) {
			
			return;
			
		}
		
		gridPersona.setItems(jpaPersona.findPersonaByParam(value, null, null, null, null));
		
		
	}

	private void crearGrillaMiembro() {
		
		gridMiembro.addColumn(p -> p.getNombre()).setId("nombre").setCaption("Nombre");
		gridMiembro.addColumn(p -> p.getApellido()).setId("apellido").setCaption("Apellido");
		gridMiembro.addColumn(p -> p.getNumeroDocumento()).setId("numeroDocumento").setCaption("Numero Documento");
		
	}

	private void crearGrillaPersona() {
		
		gridPersona.addColumn(p -> p.getNombre()).setId("nombre").setCaption("Nombre");
		gridPersona.addColumn(p -> p.getApellido()).setId("apellido").setCaption("Apellido");
		gridPersona.addColumn(p -> p.getNumeroDocumento()).setId("numeroDocumento").setCaption("Numero Documento");
		gridPersona.addColumn(p -> {
			
			if(p.getHan() != null) {
				
				return p.getHan().getDescripcion();
				
			}else {
				
				return "Sin Han";
				
			}
			
		}).setId("han").setCaption("Han");
		
	}

	private void cargarCombos() {
		
		cbxRegion.setItems(jpaRegion.findRegionEntities());
		cbxRegion.setEmptySelectionAllowed(false);
		cbxRegion.setItemCaptionGenerator(e -> e.getDescripcion());
		cbxRegion.addValueChangeListener(e -> cargarCabildo(e.getValue()));
		
		
	}

	private void cargarCabildo(Region value) {
		
		cbxCabildo.setItems(jpaCabildo.findCabildoByRegion(value));
		cbxCabildo.setEmptySelectionAllowed(false);
		cbxCabildo.setItemCaptionGenerator(e -> e.getDescripcion());
		cbxCabildo.addValueChangeListener(e -> cargarDistrito(e.getValue()));
		
	}

	private void cargarDistrito(Cabildo value) {
		
		cbxDistrito.setItems(jpaDistrito.findDistritoByCabildo(value));
		cbxDistrito.setEmptySelectionAllowed(false);
		cbxDistrito.setItemCaptionGenerator(e-> e.getDescripcion());
		cbxDistrito.addValueChangeListener(e -> cargarHan(e.getValue()));
		
	}

	private void cargarHan(Distrito value) {
		
		cbxHan.setItems(jpaHan.findHanByDistrito(value));
		cbxHan.setEmptySelectionAllowed(false);
		cbxHan.setItemCaptionGenerator(e -> e.getDescripcion());
		
	}

	private void buildMainLayout() {
		
		mainLayout = new VerticalLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		setWidth("100%");
		setHeight("-1px");
		formLayout = buildFormLayout();
		mainLayout.addComponent(formLayout);
		
	}

	private VerticalLayout buildFormLayout() {
		
		formLayout = new VerticalLayout();
		
		cabeceraLayout = buildCabeceraLayout();
		formLayout.addComponent(cabeceraLayout);
		
		txtBusqueda = new TextField();
		txtBusqueda.setCaption("Persona");
		formLayout.addComponent(txtBusqueda);
		
		datosLayout = buildDatosLayout();
		formLayout.addComponent(datosLayout);
		
		botonLayout = buildBotonLayout();
		formLayout.addComponent(botonLayout);
		formLayout.setComponentAlignment(botonLayout, Alignment.MIDDLE_CENTER);
		
		
		return formLayout;
		
	}

	private HorizontalLayout buildBotonLayout() {
		
		botonLayout = new HorizontalLayout();
		
		btnGuardar = new Button();
		btnGuardar.setCaption("Guardar");
		btnGuardar.setStyleName(ValoTheme.BUTTON_FRIENDLY);
		botonLayout.addComponent(btnGuardar);
		
		btnSalir = new Button();
		btnSalir.setCaption("Salir");
		btnSalir.setStyleName(ValoTheme.BUTTON_DANGER);
		botonLayout.addComponent(btnSalir);
		
		return botonLayout;
		
	}

	private HorizontalLayout buildDatosLayout() {
		
		datosLayout = new HorizontalLayout();
		
		gridPersona = new Grid<Persona>();
		gridPersona.setCaption("Miembros");
		datosLayout.addComponent(gridPersona);
		
		gridMiembro = new Grid<Persona>();
		gridMiembro.setCaption("Miembros Pertenecientes");
		datosLayout.addComponent(gridMiembro);
		
		
		return datosLayout;
		
	}

	private HorizontalLayout buildCabeceraLayout() {
		
		cabeceraLayout = new HorizontalLayout();
		
		cbxRegion = new ComboBox<Region>();
		cbxRegion.setCaption("Region");
		cabeceraLayout.addComponent(cbxRegion);
		
		cbxCabildo = new ComboBox<Cabildo>();
		cbxCabildo.setCaption("Cabildo");
		cabeceraLayout.addComponent(cbxCabildo);
		
		cbxDistrito = new ComboBox<Distrito>();
		cbxDistrito.setCaption("Distrito");
		cabeceraLayout.addComponent(cbxDistrito);
		
		cbxHan = new ComboBox<Han>();
		cbxHan.setCaption("Han");
		cabeceraLayout.addComponent(cbxHan);
		
		return cabeceraLayout;
		
	}
	
	
}
