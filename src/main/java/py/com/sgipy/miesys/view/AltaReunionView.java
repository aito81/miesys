package py.com.sgipy.miesys.view;


import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import py.com.sgipy.miesys.entities.Estudio;
import py.com.sgipy.miesys.entities.Han;
import py.com.sgipy.miesys.entities.Ocupacion;
import py.com.sgipy.miesys.entities.Reunion;
import py.com.sgipy.miesys.jpa.JpaEstudio;
import py.com.sgipy.miesys.jpa.JpaHan;
import py.com.sgipy.miesys.util.JpaUtil;
import py.com.sgipy.miesys.util.StringUtils;
import py.com.sgipy.miesys.util.ViewConfig;


@ViewConfig(uri = "ReunionAlta", displayName = "Alta de Reuniones")
public class AltaReunionView extends CustomComponent implements View{
	
	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private HorizontalLayout altaReunionLayout;
	private HorizontalLayout altaEstudioLayout;
	
	private ComboBox<Han> cbxHan;
	private ComboBox<Estudio> cbxEstudio;
	
	private DateField dfFechaReunion;
	
	private Button btnAddEstudio;
	private Button btnAltaReunion;
	
	private JpaHan jpaHan = new JpaHan(JpaUtil.getEntityManagerFactory());
	private JpaEstudio jpaEstudio = new JpaEstudio(JpaUtil.getEntityManagerFactory());
	
	
	
	
	public AltaReunionView () {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		cargarCombos();
		btnAddEstudio.addClickListener(e -> addEstudio());
		btnAltaReunion.addClickListener(e -> addReunion());
		
		
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
		
		Reunion addReu = new Reunion();
		addReu.setReunion(1);
		addReu.setHan(cbxHan.getValue());
		addReu.setEstudio(cbxEstudio.getValue());
		addReu.setFecha(StringUtils.convertirLocalDateToDate(dfFechaReunion.getValue()));
		
		try {
			
			jpa
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
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
		
		altaReunionLayout = buildAltaReunionLayout();
		formLayout.addComponent(altaReunionLayout);
		
		return formLayout;
	}




	private HorizontalLayout buildAltaReunionLayout() {
		
		altaReunionLayout = new HorizontalLayout();
		
		cbxHan = new ComboBox<Han>();
		cbxHan.setCaption("Han");
		altaReunionLayout.addComponent(cbxHan);
		
		altaEstudioLayout = buildAltaEstudioLayout();
		altaReunionLayout.addComponent(altaEstudioLayout);
		
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
