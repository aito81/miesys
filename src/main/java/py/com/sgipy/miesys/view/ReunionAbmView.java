package py.com.sgipy.miesys.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Grid.ItemClick;
import com.vaadin.ui.components.grid.ItemClickListener;
import com.vaadin.ui.renderers.HtmlRenderer;
import com.vaadin.ui.renderers.LocalDateRenderer;
import com.vaadin.ui.themes.ValoTheme;

import py.com.sgipy.miesys.MiesysUI;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Persona;
import py.com.sgipy.miesys.entities.Reunion;
import py.com.sgipy.miesys.jpa.JpaHan;
import py.com.sgipy.miesys.jpa.JpaReunion;
import py.com.sgipy.miesys.jpa.JpaReunionAsistencia;
import py.com.sgipy.miesys.util.JpaUtil;
import py.com.sgipy.miesys.util.StringUtils;
import py.com.sgipy.miesys.util.ViewConfig;

@ViewConfig(uri = "ReunionAbm", displayName = "Mantenimiento de Reuniones")
public class ReunionAbmView extends CustomComponent implements View {
	
	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private HorizontalLayout busquedaLayout;
	private VerticalLayout datosLayout;
	private HorizontalLayout botonLayout;
	
	private ComboBox<Han> cbxHan;
	
	private Grid<Reunion> gridReunion;
	
	private DateField dfDesde;
	private DateField dfHasta;
	
	private Button btnBuscar;
	private Button btnSalir;
	
	private JpaReunionAsistencia jpaReuAsi = new JpaReunionAsistencia(JpaUtil.getEntityManagerFactory());
	private JpaHan jpaHan = new JpaHan(JpaUtil.getEntityManagerFactory());
	private JpaReunion jpaReu = new JpaReunion(JpaUtil.getEntityManagerFactory());
	
	private Window ventana;
	
	
	
	public ReunionAbmView() {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		cargarCombos();
		crearGrilla();
		btnBuscar.addClickListener(e -> buscarReunion());
		btnSalir.addClickListener(e -> MiesysUI.getCurrent().getNavigator().navigateTo(""));
		
		
	}




	private void buscarReunion() {
		
		if (cbxHan.getValue() == null) {
			
			Notification.show("Se debe cargar Han", Notification.TYPE_ERROR_MESSAGE);
			cbxHan.focus();
			return;
			
		}
		
		if (dfDesde.isEmpty()) {
			
			Notification.show("Se debe cargar fecha desde.", Notification.TYPE_ERROR_MESSAGE);
			dfDesde.focus();
			return;
			
		}
		
		if (dfHasta.isEmpty()) {
			
			 LocalDate ahora = LocalDate.now();
			dfHasta.setValue(ahora);
			
		}
		
		gridReunion.setItems(jpaReu.findReunionByFechaAndFecha(cbxHan.getValue(), Date.valueOf(dfDesde.getValue()), 
				Date.valueOf(dfHasta.getValue())));
		
	}




	private void crearGrilla() {

		gridReunion.addColumn(e -> e.getEstudio().getDescripcion()).setId("Estudio").setCaption("Estudio");
		gridReunion.addColumn(e -> {
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(e.getFecha());
		
		}).setId("fecha").setCaption("Fecha de la Reunion");;
		
		gridReunion.addColumn(e -> 
		e.getCantidadParticipantes()).setId("cantidad").setCaption("Asistentes");
		
		gridReunion.addColumn(Persona -> FontAwesome.EYE.getHtml(), 
				new HtmlRenderer()).setId("ver").setStyleGenerator(matriz ->
				"align-center").setWidth(70).setCaption("Ver");
		
		gridReunion.addColumn(Persona -> FontAwesome.EDIT.getHtml(),
				new HtmlRenderer()).setId("editar").setStyleGenerator(matriz ->
		"align-center").setWidth(70).setCaption("Editar");
		
		gridReunion.getDefaultHeaderRow().join("ver","editar").setText("Opciones");
		
		gridReunion.addItemClickListener(new ItemClickListener<Reunion>() {

			@Override
			public void itemClick(ItemClick<Reunion> event) {

				if (event.getColumn().getId().equals("ver")) {
					verReunionDetalle(event.getItem());
				}
				
				if (event.getColumn().getId().equals("editar")) {
					editarReunionDetalle(event.getItem());
				}
				
			}

		});
		
	}

	protected void editarReunionDetalle(Reunion item) {
		
		/*AltaPersonaView editPersona = new AltaPersonaView(per);
		ventana = new Window("Consulta de Datos", editPersona);
		ventana.center();
		ventana.setSizeFull();
		
		UI.getCurrent().addWindow(ventana);
		ventana.addCloseListener(e -> gridPersona.setItems(jpaPer.findPersonaEntities()));*/
		
		AltaReunionView editPersona = new AltaReunionView(item, "ee");
		ventana = new Window("Consulta de Datos", editPersona);
		ventana.center();
		ventana.setSizeFull();
		
		UI.getCurrent().addWindow(ventana);
		
		ventana.addCloseListener(e -> gridReunion.setItems(jpaReu.findReunionByFechaAndFecha(cbxHan.getValue(),
				Date.valueOf(dfDesde.getValue()), 
				Date.valueOf(dfHasta.getValue()))));
		
		
		
		
	}




	private void verReunionDetalle(Reunion item) {

		AltaReunionView editPersona = new AltaReunionView(item);
		ventana = new Window("Consulta de Datos", editPersona);
		ventana.center();
		ventana.setSizeFull();
		//editPersona.getAltaLayout().setEnabled(false);
		//editPersona.getMainLayout().setEnabled(false);
		//editPersona.getBotonLayout().setVisible(false);
		//editPersona.getFormLayout().setEnabled(false);
		
		UI.getCurrent().addWindow(ventana);
		
	}


	private void cargarCombos() {

		cbxHan.setItems(jpaHan.findHanEntities());
		cbxHan.setEmptySelectionAllowed(false);
		cbxHan.setItemCaptionGenerator(gen -> gen.getDescripcion());
		
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
		
		busquedaLayout = buildBusquedaLayout();
		formLayout.addComponent(busquedaLayout);
		
		datosLayout = buildDatosLayout();
		formLayout.addComponent(datosLayout);
		
		botonLayout = buildBotonLayout();
		formLayout.addComponent(botonLayout);
		formLayout.setComponentAlignment(botonLayout, Alignment.BOTTOM_LEFT);
		
		return formLayout;
		
	}




	private HorizontalLayout buildBotonLayout() {

		botonLayout = new HorizontalLayout();
		
		btnSalir = new Button();
		btnSalir.setCaption("Volver");
		btnSalir.setStyleName(ValoTheme.BUTTON_DANGER);
		botonLayout.addComponent(btnSalir);
		
		return botonLayout;
		
	}




	private VerticalLayout buildDatosLayout() {
		
		datosLayout = new VerticalLayout();
		datosLayout.setHeight("-1px");
		datosLayout.setWidth("100%");
		datosLayout.setMargin(false);
		datosLayout.setSpacing(false);
		
		gridReunion = new Grid<Reunion>();
		gridReunion.setWidth("100%");
		datosLayout.addComponent(gridReunion);
		
		return datosLayout;
		
	}




	private HorizontalLayout buildBusquedaLayout() {
		
		busquedaLayout = new HorizontalLayout();
		busquedaLayout.setMargin(false);
		busquedaLayout.setSpacing(true);
		
		cbxHan = new ComboBox<Han>();
		cbxHan.setCaption("Han");
		busquedaLayout.addComponent(cbxHan);
		
		dfDesde = new DateField();
		dfDesde.setCaption("Desde:");
		busquedaLayout.addComponent(dfDesde);
		
		dfHasta = new DateField();
		dfHasta.setCaption("Hasta:");
		busquedaLayout.addComponent(dfHasta);
		
		btnBuscar = new Button();
		btnBuscar.setCaption("Buscar");
		btnBuscar.setStyleName(ValoTheme.BUTTON_PRIMARY);
		busquedaLayout.addComponent(btnBuscar);
		busquedaLayout.setComponentAlignment(btnBuscar, Alignment.BOTTOM_CENTER);
		
		return busquedaLayout;
		
	}
	
	
	
	
	
}
