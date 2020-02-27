package py.com.sgipy.miesys.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.shared.Registration;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
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
	private Button btnBuscar;
	
	private JpaRegion jpaRegion = new JpaRegion(JpaUtil.getEntityManagerFactory());
	private JpaCabildo jpaCabildo = new JpaCabildo(JpaUtil.getEntityManagerFactory());
	private JpaDistrito jpaDistrito = new JpaDistrito(JpaUtil.getEntityManagerFactory());
	private JpaHan jpaHan = new JpaHan(JpaUtil.getEntityManagerFactory());
	private JpaPersona jpaPersona = new JpaPersona(JpaUtil.getEntityManagerFactory());
	
	private List<Persona> listMiembros = new ArrayList<Persona>();
	private List<Persona> listPersonas = new ArrayList<Persona>();
	private List<Persona> listRemovidos = new ArrayList<Persona>();
	
	private Registration registration;
	
	private Boolean entro = false;
	
	
	
	public HorizontalLayout getCabeceraLayout() {
		return cabeceraLayout;
	}


	public void setCabeceraLayout(HorizontalLayout cabeceraLayout) {
		this.cabeceraLayout = cabeceraLayout;
	}


	public Grid<Persona> getGridPersona() {
		return gridPersona;
	}


	public void setGridPersona(Grid<Persona> gridPersona) {
		this.gridPersona = gridPersona;
	}


	public Grid<Persona> getGridMiembro() {
		return gridMiembro;
	}


	public void setGridMiembro(Grid<Persona> gridMiembro) {
		this.gridMiembro = gridMiembro;
	}

	
	
	
	public TextField getTxtBusqueda() {
		return txtBusqueda;
	}


	public void setTxtBusqueda(TextField txtBusqueda) {
		this.txtBusqueda = txtBusqueda;
	}

	

	public Button getBtnGuardar() {
		return btnGuardar;
	}


	public void setBtnGuardar(Button btnGuardar) {
		this.btnGuardar = btnGuardar;
	}
	
	

	public Button getBtnSalir() {
		return btnSalir;
	}


	public void setBtnSalir(Button btnSalir) {
		this.btnSalir = btnSalir;
	}


	public PersonaHanView() {
		
		buildMainLayout();
		
		setCompositionRoot(mainLayout);
		
		txtBusqueda.setEnabled(false);
		
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
		
		gridPersona.addItemClickListener(e -> hacerMiembro(e.getItem()));
		
		gridMiembro.addItemClickListener(e -> cambiarPersona(e.getItem()));
		
		btnBuscar.addClickListener(e -> buscarMiembros(cbxHan.getValue()));
		
		//remover listener...revisar..esta mal planteando..tiene que ser el listener de buscar..no el de guardar
		
		/*registration = btnGuardar.addClickListener(event -> buscarMiembros(cbxHan.getValue()));
		
		registration.remove();*/
		
		btnGuardar.addClickListener(e -> guardar(listMiembros, cbxHan.getValue()));
		
		
		
		
	}
	
	
	public PersonaHanView(Han han) {
		
		buildMainLayout();
		
		setCompositionRoot(mainLayout);
		
		cargarCombos();
		
		crearGrillaPersona();
		
		crearGrillaMiembro();
		
		txtBusqueda.addValueChangeListener(e -> buscarPersona(e.getValue()));
		
	
		
		gridPersona.addItemClickListener(e -> hacerMiembro(e.getItem()));
		
		gridMiembro.addItemClickListener(e -> cambiarPersona(e.getItem()));
		
		btnBuscar.addClickListener(e -> buscarMiembros(cbxHan.getValue()));
		
		cargarCabecera(han);
		
		cabeceraLayout.setEnabled(false);
		
		buscarMiembros(han);
		
		btnBuscar.setVisible(false);
		
		
		
		
		
	}
	
	
	
	

	private void cargarCabecera(Han han) {
		
		cbxRegion.setSelectedItem(han.getDistrito().getCabildo().getRegion());
		cbxCabildo.setSelectedItem(han.getDistrito().getCabildo());
		cbxDistrito.setSelectedItem(han.getDistrito());
		cbxHan.setSelectedItem(han);
		
	}


	private void buscarMiembros(Han value) {
		
		/*if (entro == true) {
			
			entro = false;
			
			return ;
			
		}*/
		
		
		if (value == null) {
			
			Notification.show("Debe de seleccionar un Han", Notification.TYPE_ERROR_MESSAGE);
			
			/*registration.remove();
			registration = btnBuscar.addClickListener(e ->  buscarHan());*/
			
			//entro = true;
			
			return;
			
		}
		
		
	/*	registration.remove();
		registration = btnBuscar.addClickListener(e ->  buscarHan());*/
		
		btnBuscar.getListeners(ClickEvent.class)
	    .forEach( listener -> btnBuscar.removeListener(ClickEvent.class, listener));
		
		btnBuscar.addClickListener(e ->  buscarHan());
		
		txtBusqueda.setEnabled(true);
		
		btnBuscar.setCaption("Cancelar");
		btnBuscar.setStyleName(ValoTheme.BUTTON_DANGER);
		
		cbxRegion.setEnabled(false);
		cbxCabildo.setEnabled(false);
		cbxDistrito.setEnabled(false);
		cbxHan.setEnabled(false);
		
		listMiembros.addAll(jpaPersona.findMiembrosHan(value));
		gridMiembro.setItems(listMiembros);
		gridMiembro.setEnabled(true);
		
		gridPersona.setEnabled(true);
		
		
		//btnBuscar.removeClickListener(e -> buscarMiembros(cbxHan.getValue()));
		
		
		
		
		
		
		
		
		
	}

	private void buscarHan() {
		
		//registration.remove();
		
		cbxRegion.setEnabled(true);
		cbxRegion.clear();
		
		cbxCabildo.setEnabled(true);
		cbxCabildo.clear();
		
		cbxDistrito.setEnabled(true);
		cbxDistrito.clear();
		
		cbxHan.setEnabled(true);
		cbxHan.clear();
		
		btnBuscar.setCaption("Buscar Miembros");
		btnBuscar.setStyleName(ValoTheme.BUTTON_PRIMARY);
		
		listMiembros.clear();
		gridMiembro.setItems(listMiembros);
		gridMiembro.setEnabled(false);
		
		listPersonas.clear();
		gridPersona.setItems(listPersonas);
		gridPersona.setEnabled(false);
		
		txtBusqueda.setEnabled(false);
		txtBusqueda.clear();
		
		btnBuscar.getListeners(ClickEvent.class)
	    .forEach( listener -> btnBuscar.removeListener(ClickEvent.class, listener));
		
	//	btnBuscar.addClickListener(e -> buscarMiembros(cbxHan.getValue()));
		
		btnBuscar.addClickListener(e -> buscarMiembros(cbxHan.getValue()));
		
		//btnBuscar.removeClickListener(e -> buscarHan());
		
		//registration = btnBuscar.addClickListener(e -> buscarMiembros(cbxHan.getValue()));
		
		
		
		
	}

	private void guardar(List<Persona> listMiembros2, Han value) {

		for (Persona miembro : listMiembros2) {
			
			miembro.setHan(value);
			
			try {
				
				jpaPersona.edit(miembro);
				
			} catch (Exception e) {
				
				Notification.show(e.getMessage() + " Error al asignar han a persona ", Notification.TYPE_ERROR_MESSAGE);
				
				return;
				
			}
			
		}
		
		Notification.show("Miembros agregados correctamente.");
		
		listRemovidos.removeAll(listMiembros2);
		
		for (Persona per : listRemovidos) {
			
			try {
				
				jpaPersona.edit(per);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		buscarHan();
		
		
		
		
	}

	

	private void hacerMiembro(Persona item) {
		
		if (item == null) {
			
			return;
			
		}
		
		listPersonas.remove(item);
		listMiembros.add(item);
		
		gridPersona.setItems(listPersonas);
		gridMiembro.setItems(listMiembros);
		
		
		
		
	}

	private void cambiarPersona(Persona item) {
		
		if (item == null) {
			
			return;
			
		}
		
		listPersonas.add(item);
		item.setHan(null);
		listRemovidos.add(item);
		listMiembros.remove(item);
		
		gridMiembro.setItems(listMiembros);
		gridPersona.setItems(listPersonas);
		
		
		
	}

	private void buscarPersona(String value) {
		
		if ((value.isEmpty()) || (value == null)) {
			
			return;
			
		}
		
		gridPersona.setItems(jpaPersona.findPersonaLikeNombreApellidoNotInHan(value, cbxHan.getValue()));
		
		
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
		cbxDistrito.setItemCaptionGenerator(e-> e.getDescripcion());
		cbxDistrito.addValueChangeListener(e -> cargarHan(e.getValue()));
		
	}

	private void cargarHan(Distrito value) {
		
		if (value == null) {
			
			return;
			
		}
		
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
		gridPersona.setEnabled(false);
		datosLayout.addComponent(gridPersona);
		
		gridMiembro = new Grid<Persona>();
		gridMiembro.setEnabled(false);
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
		
		btnBuscar = new Button();
		btnBuscar.setCaption("Buscar Miembros");
		btnBuscar.setStyleName(ValoTheme.BUTTON_PRIMARY);
		cabeceraLayout.addComponent(btnBuscar);
		cabeceraLayout.setComponentAlignment(btnBuscar, Alignment.BOTTOM_CENTER);
		
		return cabeceraLayout;
		
	}
	
	
}
