package py.com.sgipy.miesys.view;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import py.com.sgipy.miesys.MiesysUI;
import py.com.sgipy.miesys.controllers.exceptions.IllegalOrphanException;
import py.com.sgipy.miesys.controllers.exceptions.NonexistentEntityException;
import py.com.sgipy.miesys.entities.Estudio;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Ocupacion;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.Reunion;
import py.com.sgipy.miesys.entities.ReunionAsistencia;
import py.com.sgipy.miesys.jpa.JpaEstudio;
import py.com.sgipy.miesys.jpa.JpaHan;
import py.com.sgipy.miesys.jpa.JpaPersona;
import py.com.sgipy.miesys.jpa.JpaReunion;
import py.com.sgipy.miesys.jpa.JpaReunionAsistencia;
import py.com.sgipy.miesys.util.JpaUtil;
import py.com.sgipy.miesys.util.StringUtils;
import py.com.sgipy.miesys.util.ViewConfig;


@ViewConfig(uri = "ReunionAlta", displayName = "Alta de Reuniones")
public class AltaReunionView extends CustomComponent implements View{
	
	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private HorizontalLayout altaReunionLayout;
	private HorizontalLayout altaEstudioLayout;
	private HorizontalLayout detalleReunionLayout;
	private VerticalLayout personasLayout;
	private VerticalLayout asistentesLayout;
	private HorizontalLayout botonLayout;
	
	private ComboBox<Han> cbxHan;
	private ComboBox<Estudio> cbxEstudio;
	private ComboBox<Persona> cbxPersona;
	
	private DateField dfFechaReunion;
	
	private Button btnAddEstudio;
	private Button btnAltaReunion;
	private Button btnGuardar;
	private Button btnSalir;
	
	private TextField txtBuscar;
	
	private JpaHan jpaHan = new JpaHan(JpaUtil.getEntityManagerFactory());
	private JpaEstudio jpaEstudio = new JpaEstudio(JpaUtil.getEntityManagerFactory());
	private JpaReunion jpaReu = new JpaReunion(JpaUtil.getEntityManagerFactory());
	private JpaPersona jpaPersona = new JpaPersona(JpaUtil.getEntityManagerFactory());
	private JpaReunionAsistencia jpaReuAsis = new JpaReunionAsistencia(JpaUtil.getEntityManagerFactory());
	
	private Grid<Persona> gridPersona;
	private Grid<ReunionAsistencia> gridReuAsis;
	
	private Reunion addReu = new Reunion();
	
	private List<ReunionAsistencia> listReuAsi = new ArrayList<ReunionAsistencia>();
	private List<Persona> listPersona = new ArrayList<Persona>();
	
	private EntityManager entMan;
	
	
	
	public AltaReunionView () {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		cargarCombos();
		
		btnAddEstudio.addClickListener(e -> addEstudio());
		btnAltaReunion.addClickListener(e -> addReunion());
		
		crearGrillaPersonas();
		
		crearGrillaAsistente();
		
		txtBuscar.addValueChangeListener(e-> cargarGrillaPersona(e.getValue()));
		
		txtBuscar.setEnabled(false);
		
		detalleReunionLayout.setEnabled(false);
		
		btnGuardar.setEnabled(false);
		
		gridPersona.addItemClickListener(e -> {
		
			if (e.getItem() != null) {
				
				pasarAsistente(e.getItem(), addReu);
			}
		});
		
		gridReuAsis.addItemClickListener(e -> {
			
			if (e.getItem() != null) {
				
				listReuAsi.remove(e.getItem());
				
				gridReuAsis.setItems(listReuAsi);
				
				txtBuscar.clear();
				
			}
			
		});
		
		btnGuardar.addClickListener(e -> {
		
			if (!listReuAsi.isEmpty()) {
				
				guardar(listReuAsi);
				
			}
			
		});
		
		btnSalir.addClickListener(e -> salir());
		
		
		
	}
	
	public AltaReunionView(Reunion reu) {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		cargarCombos();
		
		cbxHan.setValue(reu.getHan());
		
		cbxEstudio.setValue(reu.getEstudio());
		
		cbxPersona.setValue(reu.getPersona());
		
		Instant instant = Instant.ofEpochMilli(reu.getFecha().getTime());
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		LocalDate localDate = localDateTime.toLocalDate();
	
		dfFechaReunion.setValue(localDate);
		
		crearGrillaAsistente();
		
		crearGrillaPersonas();
		
		for (ReunionAsistencia reuAs : reu.getReunionAsistenciaList()) {
			
			listReuAsi.add(reuAs);
			
		}
		
		gridReuAsis.setItems(listReuAsi);
		
		formLayout.setEnabled(false);
		
		botonLayout.setVisible(false);
		
	}
	
	public AltaReunionView(Reunion reu, String edit) {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		cargarCombos();
		
		cbxHan.setValue(reu.getHan());
		
		cbxEstudio.setValue(reu.getEstudio());
		
		cbxPersona.setValue(reu.getPersona());
		
		Instant instant = Instant.ofEpochMilli(reu.getFecha().getTime());
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		LocalDate localDate = localDateTime.toLocalDate();
	
		dfFechaReunion.setValue(localDate);
		
		//altaReunionLayout.setEnabled(false);
		
		botonLayout.setEnabled(false);
		
		crearGrillaAsistente();
		
		crearGrillaPersonas();
		
		for (ReunionAsistencia reuAs : reu.getReunionAsistenciaList()) {
			
			listReuAsi.add(reuAs);
			
		}
		
		gridReuAsis.setItems(listReuAsi);
		
		addReu = reu;
		
		txtBuscar.addValueChangeListener(e-> cargarGrillaPersona(e.getValue()));
		
		gridPersona.addItemClickListener(e -> {
			
			if (e.getItem() != null) {
				
				pasarAsistente(e.getItem(), addReu);
			}
		});
		
		gridReuAsis.addItemClickListener(e -> {
			
			if (e.getItem() != null) {
				
				
				
				//jpaReuAsis.DeleteReunionAsistenciaById(e.getItem());
				//ReunionAsistencia reuAsiSacar = e.getItem();
				
				//entMan.remove(reuAsiSacar);
				
				//jpaReuAsis.delete(e.getItem());
				
				try {
					jpaReuAsis.destroy(e.getItem().getReunionAsistencia());
					listReuAsi.remove(e.getItem());
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				gridReuAsis.setItems(listReuAsi);
				
				txtBuscar.clear();
				
			}
			
		});
		
		btnSalir.addClickListener(e -> {
			
			Window w = this.findAncestor(Window.class);
			w.close();
			
			
		});
		
		btnGuardar.addClickListener(e -> {
			
			if (!listReuAsi.isEmpty()) {
				
				borrarAsistentes(reu);
				
				guardar(listReuAsi);
				
				Window w = this.findAncestor(Window.class);
				w.close();
				
			}
			
		});
		
		btnAltaReunion.addClickListener(e -> editar(addReu));
		
		detalleReunionLayout.setEnabled(false);
		
		btnAltaReunion.setCaption("Editar estudio");
		
		txtBuscar.setEnabled(false);
		
		btnAddEstudio.addClickListener(e -> addEstudio());
		
		
	}




	private void borrarAsistentes(Reunion reu) {
		
		for (ReunionAsistencia reuAsi : reu.getReunionAsistenciaList()) {
			
			try {
				
				//jpaReuAsis.DeleteReunionAsistenciaById(reuAsi);
				jpaReuAsis.destroy(reuAsi.getReunionAsistencia());
				
				
			} catch (Exception e) {

				//Notification.show(e.getMessage(), Notification.TYPE_ERROR_MESSAGE);
				
			}
			
		}
		
	}

	private void editar(Reunion addReu2) {
		
		if (cbxHan.getValue() == null) {
			
			Notification.show("Se debe cargar el han correspondiente.", Notification.TYPE_ERROR_MESSAGE);
			
			cbxHan.focus();
			
			return;
			
		}
		
		if (cbxEstudio.getValue() == null) {
			
			Notification.show("Se debe cargar el estudio correspondiente.", Notification.TYPE_ERROR_MESSAGE);
			
			cbxEstudio.focus();
			
			return;
			
		}
		
		if (dfFechaReunion.isEmpty()) {
			
			Notification.show("Se debe cargar la fecha correspondiente.", Notification.TYPE_ERROR_MESSAGE);
			
			dfFechaReunion.focus();
			
			return;
			
		}
		
		if (cbxPersona.getValue() != null) {
			
			addReu2.setPersona(cbxPersona.getValue());
			
		}
		
		addReu2.setFecha(StringUtils.convertirLocalDateToDate(dfFechaReunion.getValue()));
		addReu2.setEstudio(cbxEstudio.getValue());
		addReu2.setHan(cbxHan.getValue());
		
		
		try {
			jpaReu.edit(addReu2);
			Notification.show("Reunion Editada correctamente.");
			altaReunionLayout.setEnabled(false);
			detalleReunionLayout.setEnabled(true);
			txtBuscar.setEnabled(true);
			botonLayout.setEnabled(true);
		} catch (Exception e) {
			Notification.show(e.getMessage(), Notification.TYPE_ERROR_MESSAGE);
		}
		
	}

	private void salir() {

		MiesysUI.getCurrent().getNavigator().navigateTo("");
		
	}




	private void guardar(List<ReunionAsistencia> listReuAsi2) {
		
		for (ReunionAsistencia reuAsi : listReuAsi2) {
			
			try {
				
				jpaReuAsis.create(reuAsi);
				
			} catch (Exception e) {
				
				Notification.show("Error al guardar los asistentes" + e.getMessage());
			}
			
		}
		
		int total = listReuAsi2.size();
		
		int nroReu = listReuAsi2.get(0).getReunion().getReunion();
			
		Reunion reu = jpaReu.findReunion(nroReu);
		
		reu.setCantidadParticipantes(total);
		
		try {
			jpaReu.edit(reu);
		} catch (IllegalOrphanException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NonexistentEntityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listPersona.clear();
		gridPersona.setItems(listPersona);
		
		listReuAsi.clear();
		gridReuAsis.setItems(listReuAsi2);
		
		cbxEstudio.clear();
		cbxHan.clear();
		
		dfFechaReunion.clear();
		
		detalleReunionLayout.setEnabled(false);
		altaReunionLayout.setEnabled(true);
		
		txtBuscar.setEnabled(false);
		
		btnGuardar.setEnabled(false);
		
	}




	private void pasarAsistente(Persona item, Reunion addReu) {

		txtBuscar.clear();
		
		ReunionAsistencia reuAsi = new ReunionAsistencia();
		reuAsi.setReunionAsistencia(1);
		reuAsi.setReunion(addReu);
		reuAsi.setPersona(item);
		
		listReuAsi.add(reuAsi);
		gridReuAsis.setItems(listReuAsi);

		cargarGrillaPersona("");
		
		
		
		
	}




	private void crearGrillaAsistente() {

		gridReuAsis.addColumn(asis -> asis.getPersona().getNombre()).setCaption("Nombre").setId("nombre");
		gridReuAsis.addColumn(asis -> asis.getPersona().getApellido()).setCaption("Apellido").setId("apellido");
		
	}




	private void cargarGrillaPersona(String value) {
		
		listPersona = jpaPersona.findAsistenteLikeNombreApellido(value, addReu);
		gridPersona.setItems(listPersona);
		
		if (!listReuAsi.isEmpty()) {
			
			for (ReunionAsistencia reuAsi : listReuAsi) {
				
				listPersona.remove(reuAsi.getPersona());
				
			}
			
			gridPersona.setItems(listPersona);
			
		}
		
		
	}




	private void crearGrillaPersonas() {

		//gridPersona.seti
		gridPersona.addColumn(per -> per.getNombre()).setCaption("Nombre").setId("nombre");
		gridPersona.addColumn(Persona::getApellido).setCaption("Apellido").setId("apellido");
		gridPersona.addColumn(per -> per.getNumeroDocumento()).setCaption("Numero Documento").setId("nroDoc");
		gridPersona.addColumn(per -> {
			
			if(per.getHan() == null) {
				
				return "Sin Han";
				
			}else {
				
				return per.getHan().getDescripcion();
				
			}
			//return null;
		}).setCaption("Han").setId("han");
		
	}




	private void addReunion() {
		
		if (cbxHan.getValue() == null) {
			
			Notification.show("Se debe cargar el han correspondiente.", Notification.TYPE_ERROR_MESSAGE);
			
			cbxHan.focus();
			
			return;
			
		}
		
		if (cbxEstudio.getValue() == null) {
			
			Notification.show("Se debe cargar el estudio correspondiente.", Notification.TYPE_ERROR_MESSAGE);
			
			cbxEstudio.focus();
			
			return;
			
		}
		
		if (dfFechaReunion.isEmpty()) {
			
			Notification.show("Se debe cargar la fecha correspondiente.", Notification.TYPE_ERROR_MESSAGE);
			
			dfFechaReunion.focus();
			
			return;
			
		}
		
		
		addReu.setReunion(1);
		addReu.setHan(cbxHan.getValue());
		addReu.setEstudio(cbxEstudio.getValue());
		addReu.setFecha(StringUtils.convertirLocalDateToDate(dfFechaReunion.getValue()));
		
		if (cbxPersona.getValue() != null) {
		
			addReu.setPersona(cbxPersona.getValue());
			
		}
		
		try {
			
			jpaReu.create(addReu);
			Notification.show("Reunion guardada correctamente.");
			abrirDetalle(addReu);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}




	private void abrirDetalle(Reunion addReu) {

		altaReunionLayout.setEnabled(false);
		
		txtBuscar.setEnabled(true);
		
		detalleReunionLayout.setEnabled(true);
		
		btnGuardar.setEnabled(true);
		
		
	}




	private void addEstudio() {

		MiniView alta = new MiniView();
		Window ventana = new Window("", alta);
		alta.getTxtAlgo().setCaption("Alta Estudio");
		ventana.center();
		ventana.setResizable(true);
		ventana.setModal(true);
		
		ventana.setCaption("Cargar Estudio");
		
		
		UI.getCurrent().addWindow(ventana);
		
		ventana.addCloseListener(e -> {
			
			if (alta.isGuardado()) {
				if ( ((Estudio)jpaEstudio.findEstudioByDesc(alta.getValor()) == null)) {
					
					guardarEstudio(alta.getValor());
				
				}else {
					Notification.show("El estudio ya se encuentra cargado.", Notification.TYPE_ERROR_MESSAGE);
				}
			}
		});
		
	}
	
	private void guardarEstudio(String valor) {
		
		Estudio estu = new Estudio();
		estu.setEstudio(1);
		estu.setDescripcion(valor.toUpperCase());
		
		jpaEstudio.create(estu);
		
		cbxEstudio.setItems(jpaEstudio.findEstudioEntities());
		
	}
	
	




	private void cargarCombos() {

		cbxHan.setItems(jpaHan.findHanEntities());
		cbxHan.setEmptySelectionAllowed(false);
		cbxHan.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		cbxEstudio.setItems(jpaEstudio.findEstudioEntities());
		cbxEstudio.setEmptySelectionAllowed(false);
		cbxEstudio.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		cbxPersona.setItems(jpaPersona.findPersonaEntities());
		cbxPersona.setItemCaptionGenerator(gen -> gen.getNombre() + " "+ gen.getApellido());
		
		
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
		formLayout.setHeight("-1px");
		formLayout.setWidth("100%");
		
		altaReunionLayout = buildAltaReunionLayout();
		formLayout.addComponent(altaReunionLayout);
		
		txtBuscar = new TextField();
		txtBuscar.setCaption("Buscar");
		formLayout.addComponent(txtBuscar);
		
		detalleReunionLayout = buildDetalleReunionLayout();
		formLayout.addComponent(detalleReunionLayout);
		
		botonLayout = buildBotonLayout();
		formLayout.addComponent(botonLayout);
		formLayout.setComponentAlignment(botonLayout, Alignment.MIDDLE_CENTER);
		
		return formLayout;
	}




	private HorizontalLayout buildBotonLayout() {
		
		botonLayout = new HorizontalLayout();
		botonLayout.setSpacing(true);
		
		btnGuardar = new Button();
		btnGuardar.setCaption("Guardar");
		botonLayout.addComponent(btnGuardar);
		
		btnSalir = new Button();
		btnSalir.setCaption("Volver");
		botonLayout.addComponent(btnSalir);
		
		return botonLayout;
	}




	private HorizontalLayout buildDetalleReunionLayout() {

		detalleReunionLayout = new HorizontalLayout();
		detalleReunionLayout.setHeight("-1px");
		detalleReunionLayout.setWidth("100%");
		//detalleReunionLayout.setMargin(true);
		detalleReunionLayout.setSpacing(true);
		
		personasLayout = buildPersonasLayout();
		detalleReunionLayout.addComponent(personasLayout);
		
		asistentesLayout = buildAsistentesLayout();
		detalleReunionLayout.addComponent(asistentesLayout);
		
		
		
		return detalleReunionLayout;
	}




	private VerticalLayout buildAsistentesLayout() {
	
		asistentesLayout = new VerticalLayout();
		asistentesLayout.setHeight("-1px");
		asistentesLayout.setWidth("100%");
		asistentesLayout.setMargin(false);
		asistentesLayout.setSpacing(false);
		
		gridReuAsis = new Grid<ReunionAsistencia>();
		gridReuAsis.setCaption("Asistentes");
		asistentesLayout.addComponent(gridReuAsis);
		
		
		return asistentesLayout;
		
	}




	private VerticalLayout buildPersonasLayout() {

		personasLayout = new VerticalLayout();
		personasLayout.setMargin(false);
		personasLayout.setSpacing(true);
		personasLayout.setWidth("100%");
		personasLayout.setHeight("-1px");
		
		gridPersona = new Grid<Persona>();
		gridPersona.setCaption("Personas");
		personasLayout.addComponent(gridPersona);
		
		
		
		return personasLayout;
		
	}




	private HorizontalLayout buildAltaReunionLayout() {
		
		altaReunionLayout = new HorizontalLayout();
		
		cbxHan = new ComboBox<Han>();
		cbxHan.setCaption("Han");
		altaReunionLayout.addComponent(cbxHan);
		
		altaEstudioLayout = buildAltaEstudioLayout();
		altaReunionLayout.addComponent(altaEstudioLayout);
		
		cbxPersona = new ComboBox<Persona>();
		cbxPersona.setCaption("Estudio a cargo de:");
		cbxPersona.setWidth("370px");
		altaReunionLayout.addComponent(cbxPersona);
		
		dfFechaReunion = new DateField();
		dfFechaReunion.setCaption("Fecha de Reunion");
		altaReunionLayout.addComponent(dfFechaReunion);
		
		btnAltaReunion = new Button();
		btnAltaReunion.setCaption("Crear Reunion");
		altaReunionLayout.addComponent(btnAltaReunion);
		altaReunionLayout.setComponentAlignment(btnAltaReunion, Alignment.BOTTOM_RIGHT);
		
		return altaReunionLayout;
		
	}




	private HorizontalLayout buildAltaEstudioLayout() {

		altaEstudioLayout = new HorizontalLayout();
		
		cbxEstudio = new ComboBox<Estudio>();
		cbxEstudio.setCaption("Estudio");
		altaEstudioLayout.addComponent(cbxEstudio);
		
		btnAddEstudio = new Button();
		btnAddEstudio.setCaption("+");
		btnAddEstudio.setDescription("Agregar Estudio");
		altaEstudioLayout.addComponent(btnAddEstudio);
		altaEstudioLayout.setComponentAlignment(btnAddEstudio, Alignment.BOTTOM_CENTER);
		
		return altaEstudioLayout;
		
	}
	
	

}
