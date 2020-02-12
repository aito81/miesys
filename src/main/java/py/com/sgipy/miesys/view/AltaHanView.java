package py.com.sgipy.miesys.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import py.com.sgipy.miesys.entities.Cabildo;
import py.com.sgipy.miesys.entities.Distrito;
import py.com.sgipy.miesys.entities.Region;

public class AltaHanView extends CustomComponent implements View {
	
	
	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private HorizontalLayout regionLayout;
	private VerticalLayout HanLayout;
	private HorizontalLayout botonLayout;
	
	private ComboBox<Region> cbxRegion;
	private ComboBox<Cabildo> cbxCabildo;
	private ComboBox<Distrito> cbxDistrito;
	
	private Button btnGuardar;
	private Button btnSalir;
	
	private TextField txtHan;
	
	
	
	
	public AltaHanView() {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
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



	private HorizontalLayout buildBotonLayout() {
		
		botonLayout = new HorizontalLayout();
		
		btnGuardar = new Button();
		btnGuardar.setCaption("Guardar");
		botonLayout.addComponent(btnGuardar);
		
		btnSalir = new Button();
		btnSalir.setCaption("Salir");
		botonLayout.addComponent(btnSalir);
		
		return botonLayout;
		
	}



	private VerticalLayout buildFormLayout() {
		
		formLayout = new VerticalLayout();
		formLayout.setWidth("100%");
		formLayout.setHeight("-1px");
		
		regionLayout = buildRegionLayout();
		formLayout.addComponent(regionLayout);
		
		HanLayout = buildHanLayout();
		formLayout.addComponent(HanLayout);
		
		return formLayout;
		
	}



	private VerticalLayout buildHanLayout() {

		HanLayout = new VerticalLayout();
		
		txtHan = new TextField();
		txtHan.setCaption("Han");
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
