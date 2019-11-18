package py.com.sgipy.miesys.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Empresa;
import py.com.sgipy.miesys.entities.EstadoCivil;
import py.com.sgipy.miesys.entities.Genero;
import py.com.sgipy.miesys.entities.Ocupacion;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.TipoDocumento;
import py.com.sgipy.miesys.jpa.JpaCiudad;
import py.com.sgipy.miesys.jpa.JpaEmpresa;
import py.com.sgipy.miesys.jpa.JpaEstadoCivil;
import py.com.sgipy.miesys.jpa.JpaGenero;
import py.com.sgipy.miesys.jpa.JpaOcupacion;
import py.com.sgipy.miesys.jpa.JpaPersona;
import py.com.sgipy.miesys.jpa.JpaTipoDocumento;
import py.com.sgipy.miesys.util.JpaUtil;

public class AltaPersonaView extends CustomComponent implements View {
	
	
	private VerticalLayout mainLayout;
	private HorizontalLayout formLayout;
	private VerticalLayout datosPersonalesLayout;
	private VerticalLayout ubicacionLayout;
	private HorizontalLayout direccionLayout;
	private VerticalLayout profesionLayout;
	private HorizontalLayout addOcupacionLayout;
	private HorizontalLayout addEmpresaLayout;
	private HorizontalLayout botonLayout;
	
	
	private TextField txtNombre;
	private TextField txtApellido;
	private TextField txtNroDoc;
	private TextField txtDir;
	
	
	
	private ComboBox<TipoDocumento> cbxTipoDoc;
	private ComboBox<EstadoCivil> cbxEstadoCivil;
	private ComboBox<Ciudad> cbxCiudad;
	private ComboBox<Ocupacion> cbxOcupacion;
	private ComboBox<Empresa> cbxEmpresa;
	private ComboBox<Genero> cbxGenero;
	
	private DateField dfNacimiento;
	
	private Button btnMas;
	private Button btnAceptar;
	private Button btnCancelar;

	private CheckBox chkLaboral;
	
	private JpaCiudad jpaCiudad = new JpaCiudad(JpaUtil.getEntityManagerFactory());
	private JpaEstadoCivil jpaEstCiv = new JpaEstadoCivil(JpaUtil.getEntityManagerFactory());
	private JpaTipoDocumento jpaTipoDoc = new JpaTipoDocumento(JpaUtil.getEntityManagerFactory());
	private JpaOcupacion jpaOcu = new JpaOcupacion(JpaUtil.getEntityManagerFactory());
	private JpaEmpresa jpaEmp = new JpaEmpresa(JpaUtil.getEntityManagerFactory());
	private JpaGenero jpaGene = new JpaGenero(JpaUtil.getEntityManagerFactory());
	private JpaPersona jpaPer = new JpaPersona(JpaUtil.getEntityManagerFactory());
	
	
	
	public AltaPersonaView(){
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		btnAceptar.addClickListener(e -> guardar());
		cargarcombos();
		//btnMas.addClickListener(e -> cargarNuevo(e.getButton().getCaption()));
		
		
	}




	private void cargarNuevo(String id) {
		
		MiniView alta = new MiniView();
		Window ventana = new Window("", alta);
		ventana.center();
		ventana.setResizable(true);
		ventana.setModal(true);
		
		
		
		if (id.equals("1")) {
			
			ventana.setCaption("Cargar Ocupacion");
			
			
			UI.getCurrent().addWindow(ventana);
			
			ventana.addCloseListener(e -> {
				
				if (alta.isGuardado()) {
					if ( ((Ocupacion)jpaOcu.findOcupacionByDesc(alta.getValor())) == null) {
						
						guardarOcu(alta.getValor());
					
					}else {
						Notification.show("La ocupacion ya se encuentra cargada.", Notification.TYPE_ERROR_MESSAGE);
					}
				}
			});
		
		}else {
			
			ventana.setCaption("Cargar Empresa");
			
			alta.getTxtAlgo().setCaption("Empresa");
			
			UI.getCurrent().addWindow(ventana);
			
			ventana.addCloseListener(e -> {
				
				if (alta.isGuardado()) {
					
					if ((Empresa) jpaEmp.findEmpresaByDesc(alta.getValor()) == null) {
						
						guardarEm(alta.getValor());
						
					}else {
						Notification.show("La empresa ya existe!", Notification.TYPE_ERROR_MESSAGE);
					}
					
						
						
					
					
				}
			});
			
		}
		
	}




	private void guardarEm(String valor) {
		
		
		Empresa addEm = new Empresa();
		addEm.setEmpresa(1);
		addEm.setDescripcion(valor.toUpperCase());
		
		jpaEmp.create(addEm);
		
		cbxEmpresa.setItems(jpaEmp.findEmpresaEntities());
		
		
		
		
		
	}





	private void guardarOcu(String valor) {
		
		
		
		Ocupacion addOcu = new Ocupacion();
		addOcu.setOcupacion(1);
		addOcu.setDescripcion(valor.toUpperCase());
		
		jpaOcu.create(addOcu);
		
		cbxOcupacion.setItems(jpaOcu.findOcupacionEntities());
		
		
	}




	




	private void cargarcombos() {

		cbxEstadoCivil.setItems(jpaEstCiv.findEstadoCivilEntities());
		cbxEstadoCivil.setEmptySelectionAllowed(false);
		cbxEstadoCivil.setItemCaptionGenerator(estado -> estado.getDescripcion());
		
		cbxTipoDoc.setItems(jpaTipoDoc.findTipoDocumentoEntities());
		cbxTipoDoc.setEmptySelectionAllowed(false);
		cbxTipoDoc.setItemCaptionGenerator(tipoDoc -> tipoDoc.getDescripcion());
		
		
		cbxCiudad.setItems(jpaCiudad.findCiudadEntities());
		cbxCiudad.setEmptySelectionAllowed(false);
		cbxCiudad.setItemCaptionGenerator(ciu -> ciu.getDescripcion());
		
		
		cbxOcupacion.setItems(jpaOcu.findOcupacionEntities());
		cbxOcupacion.setItemCaptionGenerator(ocu -> ocu.getDescripcion());
		
		cbxEmpresa.setItems(jpaEmp.findEmpresaEntities());
		cbxEmpresa.setItemCaptionGenerator(emp -> emp.getDescripcion());
		
		cbxGenero.setItems(jpaGene.findGeneroEntities());
		cbxGenero.setEmptySelectionAllowed(false);
		cbxGenero.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		
	}




	private void guardar() {
		
		Persona addPer = new Persona();
		addPer.setPersona(1);
		addPer.setNombre(txtNombre.getValue());
		addPer.setApellido(txtApellido.getValue());
		addPer.setNumeroDocumento(txtNroDoc.getValue());
		addPer.setTipoDocumento(cbxTipoDoc.getValue());
		//addPer.setNacionalidad(cbxn);
		addPer.setEstadoCivil(cbxEstadoCivil.getValue());
		//addPer.setCantidadHijos();
		addPer.setOcupacion(cbxOcupacion.getValue());
		//addPer.setFechaNacimiento(dfNacimiento.getValue());
		addPer.setEmpresa(cbxEmpresa.getValue());
		addPer.setGenero(1);
		//addPer.setDivision();
		jpaPer.create(addPer);
		
		
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
		
		botonLayout = buildBotonLayout();
		mainLayout.addComponent(botonLayout);
		mainLayout.setComponentAlignment(botonLayout, Alignment.TOP_CENTER);
		
	}




	private HorizontalLayout buildFormLayout() {
		
		formLayout = new HorizontalLayout();
		formLayout.setMargin(true);
		formLayout.setSpacing(true);
		formLayout.setWidth("100%");
		formLayout.setHeight("-1px");
		
		datosPersonalesLayout = buildDatospersonalesLayout();
		formLayout.addComponent(datosPersonalesLayout);
		
		profesionLayout = buildProfesionLayout();
		formLayout.addComponent(profesionLayout);
		
		ubicacionLayout = buildUbicacionLayout();
		formLayout.addComponent(ubicacionLayout);
		
		
		
		
		
		
		return formLayout;
	}




	private HorizontalLayout buildBotonLayout() {
			
		botonLayout = new HorizontalLayout();
		//botonLayout.setWidth("100%");
		botonLayout.setHeight("-1px");
		botonLayout.setSpacing(true);
		botonLayout.setMargin(true);
		
		btnAceptar = new Button();
		btnAceptar.setCaption("Guardar");
		botonLayout.addComponent(btnAceptar);
		
		btnCancelar = new Button();
		btnCancelar.setCaption("Cancelar");
		botonLayout.addComponent(btnCancelar);
		
		return botonLayout;
	}




	private VerticalLayout buildProfesionLayout() {
		
		profesionLayout = new VerticalLayout();
		//profesionLayout.setWidth("100%");
		profesionLayout.setHeight("-1px");
		profesionLayout.setCaption("Datos Profecionales");
		
		addOcupacionLayout = buildAddOcupacionLayout();
		profesionLayout.addComponent(addOcupacionLayout);
		
		
		addEmpresaLayout = buildAddEmpresaLayout();
		profesionLayout.addComponent(addEmpresaLayout);
		
		/*cbxEmpresa = new ComboBox<Empresa>();
		cbxEmpresa.setCaption("Empresa");
		profesionLayout.addComponent(cbxEmpresa);*/
		
		
		
		return profesionLayout;
	}




	private HorizontalLayout buildAddEmpresaLayout() {
		
		addEmpresaLayout = new HorizontalLayout();
		addEmpresaLayout.setHeight("-1px");
		
		cbxEmpresa = new ComboBox<Empresa>();
		cbxEmpresa.setCaption("Empresa");
		addEmpresaLayout.addComponent(cbxEmpresa);
		
		btnMas = new Button();
		btnMas.setCaption("+");
		btnMas.setId("2");
		//btnMas.addClickListener(e -> cargarNuevo(btnMas.getCaption()));
		btnMas.addClickListener(e -> cargarNuevo(e.getButton().getId()));
		addEmpresaLayout.addComponent(btnMas);
		addEmpresaLayout.setComponentAlignment(btnMas, Alignment.BOTTOM_CENTER);
		
		return addEmpresaLayout;
	}




	private HorizontalLayout buildAddOcupacionLayout() {
		
		addOcupacionLayout = new HorizontalLayout();
		//addOcupacionLayout.setSpacing(true);
		//addOcupacionLayout.setWidth("100%");
		addOcupacionLayout.setHeight("-1px");
		
		cbxOcupacion = new ComboBox<Ocupacion>();
		cbxOcupacion.setCaption("Ocupacion");
		addOcupacionLayout.addComponent(cbxOcupacion);
		
		btnMas = new Button();
		btnMas.setCaption("+");
		btnMas.setId("1");
		//btnMas.addClickListener(e -> cargarNuevo(e.getButton().getCaption()));
		btnMas.addClickListener(e -> cargarNuevo(e.getButton().getId()));
		addOcupacionLayout.addComponent(btnMas);
		addOcupacionLayout.setComponentAlignment(btnMas, Alignment.BOTTOM_CENTER);
		
		
		return addOcupacionLayout;
	}




	private VerticalLayout buildUbicacionLayout() {
	
		ubicacionLayout = new VerticalLayout();
		//ubicacionLayout.setMargin(true);
		//ubicacionLayout.setSpacing(true);
	//	ubicacionLayout.setWidth("100%");
		ubicacionLayout.setHeight("-1px");
		ubicacionLayout.setCaption("Ubicacion y telefono");
		
		direccionLayout = buildDireccionLayout();
		ubicacionLayout.addComponent(direccionLayout);
		
		
		
		
		return ubicacionLayout;
	}




	private HorizontalLayout buildDireccionLayout() {
		
		direccionLayout = new HorizontalLayout();
		//direccionLayout.setWidth("100%");
		direccionLayout.setHeight("-1px");
		//direccionLayout.setMargin(true);
		direccionLayout.setSpacing(true);
		
		cbxCiudad = new ComboBox<Ciudad>();
		cbxCiudad.setCaption("Ciudad");
		direccionLayout.addComponent(cbxCiudad);
		
		txtDir = new TextField();
		txtDir.setCaption("Direccion");
		direccionLayout.addComponent(txtDir);
		
		chkLaboral = new CheckBox();
		chkLaboral.setCaption("Laboral?");
		direccionLayout.addComponent(chkLaboral);
		direccionLayout.setComponentAlignment(chkLaboral, Alignment.BOTTOM_CENTER);
		
		return direccionLayout;
	}




	private VerticalLayout buildDatospersonalesLayout() {
		
		datosPersonalesLayout = new VerticalLayout();
		datosPersonalesLayout.setMargin(true);
		datosPersonalesLayout.setSpacing(true);
	//	datosPersonalesLayout.setWidth("100%");
		datosPersonalesLayout.setHeight("-1px");
		datosPersonalesLayout.setCaption("Datos Personales");
		
		txtNombre = new TextField();
		txtNombre.setCaption("Nombres:");
		datosPersonalesLayout.addComponent(txtNombre);
		
		txtApellido = new TextField();
		txtApellido.setCaption("Apellidos");
		datosPersonalesLayout.addComponent(txtApellido);
		
		cbxGenero = new ComboBox<Genero>();
		cbxGenero.setCaption("Genero");
		datosPersonalesLayout.addComponent(cbxGenero);
		
		cbxTipoDoc = new ComboBox<TipoDocumento>();
		cbxTipoDoc.setCaption("tipo Documento");
		datosPersonalesLayout.addComponent(cbxTipoDoc);
		
		txtNroDoc = new TextField();
		txtNroDoc.setCaption("Nro de Documento");
		datosPersonalesLayout.addComponent(txtNroDoc);
		
		cbxEstadoCivil = new ComboBox<EstadoCivil>();
		cbxEstadoCivil.setCaption("Estado Civil");
		datosPersonalesLayout.addComponent(cbxEstadoCivil);
		
		dfNacimiento = new DateField();
		dfNacimiento.setCaption("Fecha de Nacimiento");
		datosPersonalesLayout.addComponent(dfNacimiento);
		
		
		
		
		
		
		
		
		return datosPersonalesLayout;
	}
	

}
