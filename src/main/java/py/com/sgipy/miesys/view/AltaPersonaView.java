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

import py.com.sgipy.miesys.MiesysUI;
import py.com.sgipy.miesys.entities.Cabildo;
import py.com.sgipy.miesys.entities.Ciudad;
import py.com.sgipy.miesys.entities.Departamento;
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Division;
import py.com.sgipy.miesys.entities.Empresa;
import py.com.sgipy.miesys.entities.EstadoCivil;
import py.com.sgipy.miesys.entities.Genero;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Nacionalidad;
import py.com.sgipy.miesys.entities.Ocupacion;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.TipoDocumento;
import py.com.sgipy.miesys.jpa.JpaCabildo;
import py.com.sgipy.miesys.jpa.JpaCiudad;
import py.com.sgipy.miesys.jpa.JpaDepartamento;
import py.com.sgipy.miesys.jpa.JpaDistrito;
import py.com.sgipy.miesys.jpa.JpaDivision;
import py.com.sgipy.miesys.jpa.JpaEmpresa;
import py.com.sgipy.miesys.jpa.JpaEstadoCivil;
import py.com.sgipy.miesys.jpa.JpaGenero;
import py.com.sgipy.miesys.jpa.JpaHan;
import py.com.sgipy.miesys.jpa.JpaNacionalidad;
import py.com.sgipy.miesys.jpa.JpaOcupacion;
import py.com.sgipy.miesys.jpa.JpaPersona;
import py.com.sgipy.miesys.jpa.JpaTipoDocumento;
import py.com.sgipy.miesys.util.JpaUtil;
import py.com.sgipy.miesys.util.StringUtils;
import py.com.sgipy.miesys.util.ViewConfig;

@ViewConfig(uri = "personaAlta", displayName = "Alta de persona")
public class AltaPersonaView extends CustomComponent implements View {
	
	
	private VerticalLayout mainLayout;
	private HorizontalLayout formLayout;
	private VerticalLayout datosPersonalesLayout;
	private VerticalLayout ubicacionLayout;
	private HorizontalLayout direccionLayout;
	private VerticalLayout profesionLayout;
	private VerticalLayout cabildoLayout;
	private HorizontalLayout addOcupacionLayout;
	private HorizontalLayout addEmpresaLayout;
	private HorizontalLayout botonLayout;
	private HorizontalLayout telefonoLayout;
	
	
	private TextField txtNombre;
	private TextField txtApellido;
	private TextField txtNroDoc;
	private TextField txtDir;
	private TextField txtNroHijo;
	
	
	
	private ComboBox<TipoDocumento> cbxTipoDoc;
	private ComboBox<EstadoCivil> cbxEstadoCivil;
	private ComboBox<Ciudad> cbxCiudad;
	private ComboBox<Ocupacion> cbxOcupacion;
	private ComboBox<Empresa> cbxEmpresa;
	private ComboBox<Genero> cbxGenero;
	private ComboBox<Nacionalidad> cbxNacionalidad;
	private ComboBox<Departamento> cbxDepartamento;
	private ComboBox<Han> cbxHan;
	private ComboBox<Cabildo> cbxCabildo;
	private ComboBox<Distrito> cbxDistrito;
	private ComboBox<Division> cbxDivision;
	
	private DateField dfNacimiento;
	private DateField dfInicio;
	
	private Button btnMas;
	private Button btnAceptar;
	private Button btnCancelar;

	
	
	private JpaCiudad jpaCiudad = new JpaCiudad(JpaUtil.getEntityManagerFactory());
	private JpaEstadoCivil jpaEstCiv = new JpaEstadoCivil(JpaUtil.getEntityManagerFactory());
	private JpaTipoDocumento jpaTipoDoc = new JpaTipoDocumento(JpaUtil.getEntityManagerFactory());
	private JpaOcupacion jpaOcu = new JpaOcupacion(JpaUtil.getEntityManagerFactory());
	private JpaEmpresa jpaEmp = new JpaEmpresa(JpaUtil.getEntityManagerFactory());
	private JpaGenero jpaGene = new JpaGenero(JpaUtil.getEntityManagerFactory());
	private JpaPersona jpaPer = new JpaPersona(JpaUtil.getEntityManagerFactory());
	private JpaNacionalidad jpaNac = new JpaNacionalidad(JpaUtil.getEntityManagerFactory());
	private JpaDepartamento jpaDep = new JpaDepartamento(JpaUtil.getEntityManagerFactory());
	private JpaCabildo jpaCab = new JpaCabildo(JpaUtil.getEntityManagerFactory());
	private JpaDistrito jpaDis = new JpaDistrito(JpaUtil.getEntityManagerFactory());
	private JpaHan jpaHan = new JpaHan(JpaUtil.getEntityManagerFactory());
	private JpaDivision jpaDiv = new JpaDivision(JpaUtil.getEntityManagerFactory());
	
	
	
	public AltaPersonaView(){
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		btnAceptar.addClickListener(e -> guardar());
		cargarcombos();
		//btnMas.addClickListener(e -> cargarNuevo(e.getButton().getCaption()));
		
		btnCancelar.addClickListener(e -> salir());
		
		
	}




	private void salir() {
		// TODO Auto-generated method stub
		MiesysUI.getCurrent().getNavigator().navigateTo("");
		
	}




	private void cargarCiudades(Departamento value) {
		
		if (value == null) {
			
			return;
			
		}
		
		cbxCiudad.setItems(jpaCiudad.findCiudadesbyDepto(value));
		cbxCiudad.setEmptySelectionAllowed(false);
		cbxCiudad.setItemCaptionGenerator(ciu -> ciu.getDescripcion());
		
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
		
		cbxOcupacion.setItems(jpaOcu.findOcupacionEntities());
		cbxOcupacion.setItemCaptionGenerator(ocu -> ocu.getDescripcion());
		
		cbxEmpresa.setItems(jpaEmp.findEmpresaEntities());
		cbxEmpresa.setItemCaptionGenerator(emp -> emp.getDescripcion());
		
		cbxGenero.setItems(jpaGene.findGeneroEntities());
		cbxGenero.setEmptySelectionAllowed(false);
		cbxGenero.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		cbxNacionalidad.setItems(jpaNac.findNacionalidadEntities());
		cbxNacionalidad.setEmptySelectionAllowed(false);
		cbxNacionalidad.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		cbxDepartamento.setItems(jpaDep.findDepartamentoEntities());
		cbxDepartamento.setEmptySelectionAllowed(false);
		cbxDepartamento.setItemCaptionGenerator(gen -> gen.getDescripcion());
		cbxDepartamento.addValueChangeListener(e -> cargarCiudades(e.getValue()));
		
		cbxCabildo.setItems(jpaCab.findCabildoEntities());
		cbxCabildo.setEmptySelectionAllowed(false);
		cbxCabildo.setItemCaptionGenerator(gen -> gen.getDescripcion());
		cbxCabildo.addValueChangeListener(e -> cargarDistrito(e.getValue()));
		
		cbxDistrito.addValueChangeListener(e -> cargarHan(e.getValue()));
		
		cbxDivision.setItems(jpaDiv.findDivisionEntities());
		cbxDivision.setEmptySelectionAllowed(false);
		cbxDivision.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		
		
		
		
	}




	private void cargarHan(Distrito value) {
		
		if (value == null) {
			
			return;
			
		}
		
		cbxHan.setItems(jpaHan.findHanByDistrito(value));
		cbxHan.setEmptySelectionAllowed(false);
		cbxHan.setItemCaptionGenerator(gen -> gen.getDescripcion());
	}




	private void cargarDistrito(Cabildo cabildo) {
		
		if (cabildo == null) {
			
			return;
			
		}
		
		cbxDistrito.setItems(jpaDis.findDistritoByCabildo(cabildo));
		cbxDistrito.setEmptySelectionAllowed(false);
		cbxDistrito.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
	}




	private void guardar() {
		
		Persona addPer = new Persona();
		addPer.setPersona(1);
		addPer.setNombre(txtNombre.getValue().toUpperCase());
		addPer.setApellido(txtApellido.getValue().toUpperCase());
		addPer.setNumeroDocumento(txtNroDoc.getValue());
		addPer.setTipoDocumento(cbxTipoDoc.getValue());
		addPer.setEstadoCivil(cbxEstadoCivil.getValue());
		addPer.setOcupacion(cbxOcupacion.getValue());
		if (dfInicio.getValue() != null) {
			
			addPer.setFechaInicio(StringUtils.convertirLocalDateToDate(dfInicio.getValue()));
			
		}
		
		if (dfNacimiento.getValue() != null) {
		
			addPer.setFechaNacimiento(StringUtils.convertirLocalDateToDate(dfNacimiento.getValue()));
			
		}
		
		
		addPer.setEmpresa(cbxEmpresa.getValue());
		addPer.setGenero(cbxGenero.getValue());
		addPer.setNacionalidad(cbxNacionalidad.getValue());
		addPer.setHan(cbxHan.getValue());
		addPer.setDivision(cbxDivision.getValue());
		if (txtNroHijo.getValue() != null) {
			if (StringUtils.isNumeric(txtNroHijo.getValue())) {
				addPer.setCantidadHijos(Integer.valueOf(txtNroHijo.getValue()));
			}else {
				txtNroHijo.clear();
			}
		}
		
		//addPer.setDivision();
		try {
			jpaPer.create(addPer);
			Notification.show("Persona agregada correctamente.");
			limpiarDatos();
		} catch (Exception e) {
			Notification.show("Error al dar de alta una persona.", Notification.TYPE_ERROR_MESSAGE);
		}
		
		
		
	}




	private void limpiarDatos() {
		
		txtNombre.clear();
		txtApellido.clear();
		cbxCiudad.clear();
		cbxGenero.clear();
		cbxTipoDoc.clear();
		cbxNacionalidad.clear();
		cbxEstadoCivil.clear();
		dfNacimiento.clear();
		txtNroHijo.clear();
		cbxOcupacion.clear();
		cbxEmpresa.clear();
		cbxCabildo.clear();
		cbxDistrito.clear();
		cbxHan.clear();
		cbxDivision.clear();
		
		
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
		
		cabildoLayout = buildDistritoLayout();
		profesionLayout.addComponent(cabildoLayout);
		
		/*cbxEmpresa = new ComboBox<Empresa>();
		cbxEmpresa.setCaption("Empresa");
		profesionLayout.addComponent(cbxEmpresa);*/
		
		
		
		return profesionLayout;
	}




	private VerticalLayout buildDistritoLayout() {
		
		cabildoLayout = new VerticalLayout();
		cabildoLayout.setHeight("-1px");
		//cabildoLayout.setMargin(false);
		cabildoLayout.setSpacing(false);
		cabildoLayout.setCaption("Cabildo");
		
		cbxCabildo = new ComboBox<Cabildo>();
		cbxCabildo.setCaption("Cabildo");
		cabildoLayout.addComponent(cbxCabildo);
		
		cbxDistrito = new ComboBox<Distrito>();
		cbxDistrito.setCaption("Distrito");
		cabildoLayout.addComponent(cbxDistrito);
		
		cbxHan = new ComboBox<Han>();
		cbxHan.setCaption("Han");
		cabildoLayout.addComponent(cbxHan);
		
		cbxDivision = new ComboBox<Division>();
		cbxDivision.setCaption("División");
		cabildoLayout.addComponent(cbxDivision);
		
		dfInicio = new DateField();
		dfInicio.setCaption("Fecha de Inicio");
		cabildoLayout.addComponent(dfInicio);
		
		return cabildoLayout;
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
		ubicacionLayout.setMargin(true);
		//ubicacionLayout.setSpacing(true);
	//	ubicacionLayout.setWidth("100%");
		ubicacionLayout.setHeight("-1px");
		ubicacionLayout.setCaption("Ubicacion y telefono");
		
		direccionLayout = buildDireccionLayout();
		direccionLayout.setCaption("Laboral");
		ubicacionLayout.addComponent(direccionLayout);
		
		direccionLayout = buildDireccionLayout();
		direccionLayout.setCaption("Particular");
		ubicacionLayout.addComponent(direccionLayout);
		
		
		
		
		return ubicacionLayout;
	}




	private HorizontalLayout buildDireccionLayout() {
		
		direccionLayout = new HorizontalLayout();
		//direccionLayout.setWidth("100%");
		direccionLayout.setHeight("-1px");
		direccionLayout.setMargin(true);
		direccionLayout.setSpacing(true);
		
		cbxDepartamento = new ComboBox<Departamento>();
		cbxDepartamento.setCaption("Departamento");
		direccionLayout.addComponent(cbxDepartamento);
		
		cbxCiudad = new ComboBox<Ciudad>();
		cbxCiudad.setCaption("Ciudad");
		direccionLayout.addComponent(cbxCiudad);
		
		txtDir = new TextField();
		txtDir.setCaption("Direccion");
		direccionLayout.addComponent(txtDir);
		
		
		
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
		
		cbxNacionalidad = new ComboBox<Nacionalidad>();
		cbxNacionalidad.setCaption("Nacionalidad");
		datosPersonalesLayout.addComponent(cbxNacionalidad);
		
		cbxEstadoCivil = new ComboBox<EstadoCivil>();
		cbxEstadoCivil.setCaption("Estado Civil");
		datosPersonalesLayout.addComponent(cbxEstadoCivil);
		
		dfNacimiento = new DateField();
		dfNacimiento.setCaption("Fecha de Nacimiento");
		datosPersonalesLayout.addComponent(dfNacimiento);
		
		txtNroHijo = new TextField();
		txtNroHijo.setCaption("Cantidad de hijos");
		datosPersonalesLayout.addComponent(txtNroHijo);
		
		
		
		
		
		
		
		
		
		
		return datosPersonalesLayout;
	}
	

}
