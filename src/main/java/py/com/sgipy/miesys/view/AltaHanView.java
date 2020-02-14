package py.com.sgipy.miesys.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import py.com.sgipy.miesys.entities.Cabildo;
import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Departamento;
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Region;
import py.com.sgipy.miesys.jpa.JpaCabildo;
import py.com.sgipy.miesys.jpa.JpaCiudad;
import py.com.sgipy.miesys.jpa.JpaDepartamento;
import py.com.sgipy.miesys.jpa.JpaDistrito;
import py.com.sgipy.miesys.jpa.JpaHan;
import py.com.sgipy.miesys.jpa.JpaRegion;
import py.com.sgipy.miesys.util.Funciones;
import py.com.sgipy.miesys.util.JpaUtil;
import py.com.sgipy.miesys.util.ViewConfig;

@ViewConfig(uri = "hanAlta", displayName = "Alta de Han")
public class AltaHanView extends CustomComponent implements View {
	
	
	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private HorizontalLayout regionLayout;
	private VerticalLayout HanLayout;
	private HorizontalLayout direccionLayout;
	private HorizontalLayout botonLayout;
	
	private ComboBox<Region> cbxRegion;
	private ComboBox<Cabildo> cbxCabildo;
	private ComboBox<Distrito> cbxDistrito;
	private ComboBox<Departamento> cbxDepartamento;
	private ComboBox<Ciudad> cbxCiudad;
	
	private Button btnGuardar;
	private Button btnSalir;
	
	private TextField txtHan;
	private TextField txtDireccion;
	
	private JpaRegion jpaRegion = new JpaRegion(JpaUtil.getEntityManagerFactory());
	private JpaCabildo jpaCabildo = new JpaCabildo(JpaUtil.getEntityManagerFactory());
	private JpaDistrito jpaDistrito = new JpaDistrito(JpaUtil.getEntityManagerFactory());
	private JpaHan jpaHan = new JpaHan(JpaUtil.getEntityManagerFactory());
	private JpaDepartamento jpaDepto = new JpaDepartamento(JpaUtil.getEntityManagerFactory());
	private JpaCiudad jpaCiudad = new JpaCiudad(JpaUtil.getEntityManagerFactory());
	
	
	
	
	
	public AltaHanView() {
		
		buildMainLayout();
		
		setCompositionRoot(mainLayout);
		
		cargarCombos();
		
		btnGuardar.addClickListener(e-> guardar());
		
		btnSalir.addClickListener(e -> Funciones.salir());
		
	}



	private void guardar() {
		
		if (cbxRegion.getValue() == null) {
			
			Notification.show("Se debe ingresar la Region", Notification.TYPE_ERROR_MESSAGE);
			
			cbxRegion.focus();
			
			return;
			
		}
		
		if (cbxCabildo.getValue() == null) {
			
			Notification.show("Se debe ingresar el Cabildo", Notification.TYPE_ERROR_MESSAGE);
			
			cbxCabildo.focus();
			
			return;
			
		}
		
		if (cbxDistrito.getValue() == null) {
			
			Notification.show("Se debe ingresar el Distrito", Notification.TYPE_ERROR_MESSAGE);
			
			cbxDistrito.focus();
			
			return;
			
		}
		
		if ((txtHan.getValue().isEmpty()) || (txtHan.getValue() == null)) {
			
			Notification.show("Se debe ingresar un nombre para el Han", Notification.TYPE_ERROR_MESSAGE);
			
			txtHan.focus();
			
			return;
			
		}
		
		if (jpaHan.findHanRepetido(txtHan.getValue()) != null) {
			
			Notification.show("Ya existe un Han con ese nombre.", Notification.TYPE_ERROR_MESSAGE);
			
			txtHan.focus();
			
			txtHan.clear();
			
			return;
			
		}
		
		
		try {
			
			Han addHan = new Han();
			addHan.setHan(1);
			addHan.setDescripcion(txtHan.getValue().toUpperCase());
			addHan.setDistrito(cbxDistrito.getValue());
			
			jpaHan.create(addHan);
			
			limpiarDatos();
		} catch (Exception e) {
			
			Notification.show("Error al agregar Han" + e.getMessage(), Notification.TYPE_ERROR_MESSAGE);
			
		}
		
	}



	private void limpiarDatos() {
		
		cbxRegion.clear();
		cbxCabildo.clear();
		cbxDistrito.clear();
		txtHan.clear();
		
		
	}



	private void cargarCombos() {
		
		cargarRegion();
		cargarDepartamento();
		
	}



	private void cargarDepartamento() {
		
		cbxDepartamento.setItems(jpaDepto.findDepartamentoEntities());
		cbxDepartamento.setItemCaptionGenerator(e-> e.getDescripcion());
		cbxDepartamento.setEmptySelectionAllowed(false);
		cbxDepartamento.addValueChangeListener(e-> cargarCiudad(e.getValue()));
		
	}



	private void cargarCiudad(Departamento value) {
		
		cbxCiudad.setItems(jpaCiudad.findCiudadesbyDepto(value));
		cbxCiudad.setItemCaptionGenerator(e-> e.getDescripcion());
		cbxCiudad.setEmptySelectionAllowed(false);
		
		
	}



	private void cargarRegion() {
		
		cbxRegion.setItems(jpaRegion.findRegionEntities());
		cbxRegion.setEmptySelectionAllowed(false);
		cbxRegion.setItemCaptionGenerator(e -> e.getDescripcion());
		cbxRegion.addValueChangeListener(e -> cargarCabildo(e.getValue()));
		
	}



	private void cargarCabildo(Region value) {
		
		if (value == null) {
			
			return;
					
		}
		cbxCabildo.setItems(jpaCabildo.findCabildoByRegion(value));
		cbxCabildo.setEmptySelectionAllowed(false);
		cbxCabildo.setItemCaptionGenerator(e -> e.getDescripcion());
		cbxCabildo.addValueChangeListener(e -> cargarDistrito(e.getValue()));
		
	}



	private void cargarDistrito(Cabildo value) {
		
		if (value == null) {
			
			return;
			
		}
		
		cbxDistrito.setItems(jpaDistrito.findDistritoByCabildo(value));
		cbxDistrito.setEmptySelectionAllowed(false);
		cbxDistrito.setItemCaptionGenerator(e -> e.getDescripcion());
		
	}



	private void buildMainLayout() {

		mainLayout = new VerticalLayout();
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		/*setWidth("100%");
		setHeight("-1px");*/
		formLayout = buildFormLayout();
		mainLayout.addComponent(formLayout);
		mainLayout.setComponentAlignment(formLayout, Alignment.MIDDLE_CENTER);
		
		
		
		
		botonLayout = buildBotonLayout();
		mainLayout.addComponent(botonLayout);
		mainLayout.setComponentAlignment(botonLayout, Alignment.TOP_CENTER);
		
	}



	private HorizontalLayout buildBotonLayout() {
		
		botonLayout = new HorizontalLayout();
		
		btnGuardar = new Button();
		btnGuardar.setCaption("Guardar");
		btnGuardar.addStyleName(ValoTheme.BUTTON_FRIENDLY);
		botonLayout.addComponent(btnGuardar);
		
		btnSalir = new Button();
		btnSalir.setCaption("Salir");
		btnSalir.addStyleName(ValoTheme.BUTTON_DANGER);
		botonLayout.addComponent(btnSalir);
		
		return botonLayout;
		
	}



	private VerticalLayout buildFormLayout() {
		
		formLayout = new VerticalLayout();
		formLayout.setWidth("50%");
		formLayout.setHeight("-1px");
		
		regionLayout = buildRegionLayout();
		formLayout.addComponent(regionLayout);
		formLayout.setComponentAlignment(regionLayout, Alignment.MIDDLE_CENTER);
		
		HanLayout = buildHanLayout();
		formLayout.addComponent(HanLayout);
		formLayout.setComponentAlignment(HanLayout, Alignment.MIDDLE_CENTER);
		
		direccionLayout = buildDireccionLayout();
		formLayout.addComponent(direccionLayout);
		formLayout.setComponentAlignment(HanLayout, Alignment.MIDDLE_CENTER);
		
		
		return formLayout;
		
	}



	private HorizontalLayout buildDireccionLayout() {

		direccionLayout = new HorizontalLayout();
		
		cbxDepartamento = new ComboBox<Departamento>();
		cbxDepartamento.setCaption("Departamento");
		direccionLayout.addComponent(cbxDepartamento);
		
		cbxCiudad = new ComboBox<Ciudad>();
		cbxCiudad.setCaption("Ciudad");
		direccionLayout.addComponent(cbxCiudad);
		
		txtDireccion = new TextField();
		txtDireccion.setCaption("Direccion");
		direccionLayout.addComponent(txtDireccion);
		
		
		return direccionLayout;

		
	}



	private VerticalLayout buildHanLayout() {

		HanLayout = new VerticalLayout();
		HanLayout.setWidth("4%");
		
		txtHan = new TextField();
		txtHan.setCaption("Nombre de Han");
		txtHan.setWidth("300px");
		
		txtDireccion = new TextField();
		HanLayout.addComponent(txtHan);
		
		return HanLayout;
		
		
		
	}



	private HorizontalLayout buildRegionLayout() {
		
		regionLayout = new HorizontalLayout();
		
		cbxRegion = new ComboBox<>();
		cbxRegion.setCaption("Region");
		regionLayout.addComponent(cbxRegion);
		
		cbxCabildo = new ComboBox<>();
		cbxCabildo.setCaption("Cabildo");
		regionLayout.addComponent(cbxCabildo);
		
		cbxDistrito = new ComboBox<Distrito>();
		cbxDistrito.setCaption("Distrito");
		regionLayout.addComponent(cbxDistrito);
		
		return regionLayout;
		
	}
	
}
