package py.com.sgipy.miesys.view;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.ItemClick;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.components.grid.ItemClickListener;
import com.vaadin.ui.renderers.HtmlRenderer;
import com.vaadin.ui.themes.ValoTheme;

import py.com.sgipy.miesys.entities.Cabildo;
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Region;
import py.com.sgipy.miesys.jpa.JpaCabildo;
import py.com.sgipy.miesys.jpa.JpaDistrito;
import py.com.sgipy.miesys.jpa.JpaHan;
import py.com.sgipy.miesys.jpa.JpaRegion;
import py.com.sgipy.miesys.util.Funciones;
import py.com.sgipy.miesys.util.JpaUtil;
import py.com.sgipy.miesys.util.ViewConfig;

@ViewConfig(uri = "hanConsulta", displayName = "Han")
public class HanView extends CustomComponent implements View {
	
	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private HorizontalLayout busquedaLayout;
	private VerticalLayout datosLayout;
	private HorizontalLayout botonLayout;
	
	private ComboBox<Region> cbxRegion;
	private ComboBox<Cabildo> cbxCabildo;
	private ComboBox<Distrito> cbxDistrito;
	
	private TextField txtHan;
	
	private Button btnBuscar;
	private Button btnSalir;
	
	private Grid<Han> gridHan;
	
	private JpaRegion jpaRegion = new JpaRegion(JpaUtil.getEntityManagerFactory());
	private JpaCabildo jpaCabildo = new JpaCabildo(JpaUtil.getEntityManagerFactory());
	private JpaDistrito jpaDistrito = new JpaDistrito(JpaUtil.getEntityManagerFactory());
	private JpaHan jpaHan = new JpaHan(JpaUtil.getEntityManagerFactory());
	
	private PersonaHanView hanView;
	
	private Window ventana;
	
	
	
	
	public HanView() {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		cargarCombos();
		
		btnBuscar.addClickListener(e ->buscar(cbxRegion.getValue(), cbxCabildo.getValue(), cbxDistrito.getValue(), txtHan.getValue()));
		
		btnSalir.addClickListener(e -> Funciones.salir());
		
		crearGrilla();
		
		
		
		
	}

	private void crearGrilla() {
		
		gridHan.addColumn(e -> e.getDistrito().getCabildo().getRegion().getDescripcion()).setId("region").setCaption("Region");
		gridHan.addColumn(e -> e.getDistrito().getCabildo().getDescripcion()).setId("cabildo").setCaption("Cabildo");
		gridHan.addColumn(e -> e.getDistrito().getDescripcion()).setId("distrito").setCaption("Distrito");
		gridHan.addColumn(e -> e.getDescripcion()).setId("han").setCaption("Han");
		gridHan.addColumn(Persona -> FontAwesome.EYE.getHtml(), 
				new HtmlRenderer()).setId("ver").setStyleGenerator(matriz ->
				"align-center").setWidth(70).setCaption("Ver");
		
		gridHan.addColumn(Persona -> FontAwesome.EDIT.getHtml(),
				new HtmlRenderer()).setId("editar").setStyleGenerator(matriz ->
		"align-center").setWidth(70).setCaption("Editar");
		
		gridHan.getDefaultHeaderRow().join("ver","editar").setText("Opciones");
		
		gridHan.addItemClickListener( new ItemClickListener<Han>() {

			@Override
			public void itemClick(ItemClick<Han> event) {
				
				if (event.getColumn().getId().equals("ver")) {
					verHanDetalle(event.getItem());
				}
				
				if (event.getColumn().getId().equals("editar")) {
					editarReunionDetalle(event.getItem());
				}
				
			}

			

			
		});
		
	}
	
	
	
	private void verHanDetalle(Han item) {
		
		hanView = new PersonaHanView(item);
		hanView.getGridPersona().setVisible(false);
		hanView.getTxtBusqueda().setVisible(false);
		hanView.getGridMiembro().setEnabled(false);
		hanView.getBtnGuardar().setVisible(false);
		hanView.getBtnSalir().addClickListener(e -> ventana.close());
		
		ventana = new Window("Consulta de Han", hanView);
		ventana.center();
		ventana.setSizeFull();
		ventana.setClosable(false);
		ventana.setResizable(false);
		
		
		UI.getCurrent().addWindow(ventana);
		
	}
	
	
	private void editarReunionDetalle(Han item) {
		
		hanView = new PersonaHanView(item);
		hanView.getBtnSalir().addClickListener(e -> ventana.close());
		
		ventana = new Window("Edición de Miembros de Han", hanView);
		ventana.center();
		ventana.setSizeFull();
		ventana.setClosable(false);
		ventana.setResizable(false);
		
		UI.getCurrent().addWindow(ventana);
		
		
	}

	private void buscar(Region value, Cabildo value2, Distrito value3, String value4) {
		
		gridHan.setItems(jpaHan.findHanByParamaters(value, value2, value3, value4));

	}

	private void cargarCombos() {
		
		cargarRegion();
		
		
		
		
	}

	private void cargarRegion() {

		cbxRegion.setItems(jpaRegion.findRegionEntities());
		cbxRegion.setItemCaptionGenerator(gen -> gen.getDescripcion());
		cbxRegion.setEmptySelectionAllowed(false);
		
		cbxRegion.addValueChangeListener(e -> cargarCabildo(e.getValue()));
		
	}

	private void cargarCabildo(Region value) {
		
		cbxCabildo.setItems(jpaCabildo.findCabildoByRegion(value));
		cbxCabildo.setItemCaptionGenerator(gen -> gen.getDescripcion());
		cbxCabildo.addValueChangeListener(e -> cargarDistrito(e.getValue()));
		
		
	}

	private void cargarDistrito(Cabildo value) {
		
		cbxDistrito.setItems(jpaDistrito.findDistritoByCabildo(value));
		cbxDistrito.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
		
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
		mainLayout.setComponentAlignment(botonLayout, Alignment.BOTTOM_LEFT);
		
		
	}

	private HorizontalLayout buildBotonLayout() {
		
		botonLayout = new HorizontalLayout();
		
		btnSalir = new Button();
		btnSalir.setCaption("Salir");
		btnSalir.setStyleName(ValoTheme.BUTTON_DANGER);
		botonLayout.addComponent(btnSalir);
		
		return botonLayout;
		
	}

	private VerticalLayout buildFormLayout() {
		
		formLayout = new VerticalLayout();
		formLayout.setWidth("100%");
		formLayout.setHeight("-1px");
		formLayout.setMargin(false);
		formLayout.setSpacing(false);
		
		busquedaLayout = buildBusquedaLayout();
		formLayout.addComponent(busquedaLayout);
		
		datosLayout = buildDatosLayout();
		formLayout.addComponent(datosLayout);
		
		return formLayout;
		
	}

	private VerticalLayout buildDatosLayout() {
		
		datosLayout = new VerticalLayout();
		datosLayout.setWidth("100%");
		datosLayout.setHeight("-1px");
		
		gridHan = new Grid<>();
		gridHan.setWidth("100%");
		datosLayout.addComponent(gridHan);
		
		
		
		return datosLayout;
		
	}

	private HorizontalLayout buildBusquedaLayout() {
		
		busquedaLayout = new HorizontalLayout();
		
		cbxRegion = new ComboBox<Region>();
		cbxRegion.setCaption("Region");
		busquedaLayout.addComponent(cbxRegion);
		
		cbxCabildo = new ComboBox<Cabildo>();
		cbxCabildo.setCaption("Cabildo");
		busquedaLayout.addComponent(cbxCabildo);
		
		cbxDistrito = new ComboBox<Distrito>();
		cbxDistrito.setCaption("Distrito");
		busquedaLayout.addComponent(cbxDistrito);
		
		txtHan = new TextField();
		txtHan.setCaption("Han");
		busquedaLayout.addComponent(txtHan);
		
		btnBuscar = new Button();
		btnBuscar.setCaption("Buscar");
		btnBuscar.setStyleName(ValoTheme.BUTTON_PRIMARY);
		busquedaLayout.addComponent(btnBuscar);
		busquedaLayout.setComponentAlignment(btnBuscar, Alignment.BOTTOM_CENTER);
		
		return busquedaLayout;
		
	}
	

}
