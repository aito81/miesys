package py.com.sgipy.miesys.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import py.com.sgipy.miesys.util.StringUtils;



public class MiniView extends CustomComponent implements View{
	
	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private VerticalLayout datosLayout;
	private HorizontalLayout botonLayout;
	private TextField txtAlgo = new TextField();
	
	
	private Button btnGuardar;
	private Button btnCancelar;
	
	public TextField getTxtAlgo() {
		return txtAlgo;
	}


	public void setTxtAlgo(TextField txtAlgo) {
		this.txtAlgo = txtAlgo;
	}


	public boolean isGuardado() {
		return guardado;
	}


	public void setGuardado(boolean guardado) {
		this.guardado = guardado;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	private boolean guardado;
	
	private String valor;
	
	public MiniView() {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		btnGuardar.addClickListener(e -> {
			
			guardar(txtAlgo.getValue());
		});
		
		btnCancelar.addClickListener(e -> cerrar());
	}
	
	
	private void cerrar() {
		
		guardado = false;
		Window w = this.findAncestor(Window.class);
		w.close();
		
	}

	public VerticalLayout getMainLayout() {
		return mainLayout;
	}


	public void setMainLayout(VerticalLayout mainLayout) {
		this.mainLayout = mainLayout;
	}


	public VerticalLayout getFormLayout() {
		return formLayout;
	}


	public void setFormLayout(VerticalLayout formLayout) {
		this.formLayout = formLayout;
	}


	public VerticalLayout getDatosLayout() {
		return datosLayout;
	}


	public void setDatosLayout(VerticalLayout datosLayout) {
		this.datosLayout = datosLayout;
	}


	public HorizontalLayout getBotonLayout() {
		return botonLayout;
	}


	public void setBotonLayout(HorizontalLayout botonLayout) {
		this.botonLayout = botonLayout;
	}


	public Button getBtnGuardar() {
		return btnGuardar;
	}
	
	
	private void guardar(String value) {
		
		if (verificarDatos()) {
			
			return;
		}
		
		guardado = true;
		valor = txtAlgo.getValue();
		Window w = this.findAncestor(Window.class);
		w.close();
		
	}
	
	
	
	
	private boolean verificarDatos() {
		
		if (txtAlgo.isEmpty()) {
			Notification.show("El valor del peso no puede quedar vacio", Notification.TYPE_ERROR_MESSAGE);
			txtAlgo.focus();
			return true;
		}
		
		/*String valor = txtAlgo.getValue().replace(",", ".");
		if (!StringUtils.isDoubleNumeric(valor)) {
			Notification.show("El peso debe de ser numerico.", Notification.TYPE_ERROR_MESSAGE);
			txtAlgo.clear();
			txtAlgo.focus();
			return true;
		}*/
		
		return false;
	}


	public void setBtnGuardar(Button btnGuardar) {
		this.btnGuardar = btnGuardar;
	}


	public Button getBtnCancelar() {
		return btnCancelar;
	}


	public void setBtnCancelar(Button btnCancelar) {
		this.btnCancelar = btnCancelar;
	}


	private void buildMainLayout() {
		
		mainLayout = new VerticalLayout();
		mainLayout.setHeight("100%");
		mainLayout.setHeight("-1px");
		
		formLayout = buildForLayout();
		mainLayout.addComponent(formLayout);
		
	
		
		
	}


	private VerticalLayout buildForLayout() {
		
		formLayout = new VerticalLayout();
		formLayout.setWidth("100%");
		formLayout.setHeight("-1px");
		
		datosLayout = buildDatoslayout();
		formLayout.addComponent(datosLayout);
		
		botonLayout = buildBotonLayout();
		formLayout.addComponent(botonLayout);
		
		return formLayout;
	}


	private HorizontalLayout buildBotonLayout() {
		
		botonLayout = new HorizontalLayout();
		
		btnGuardar = new Button();
		btnGuardar.setCaption("Guardar");
		botonLayout.addComponent(btnGuardar);
		
		btnCancelar = new Button();
		btnCancelar.setCaption("Salir");
		botonLayout.addComponent(btnCancelar);
		
		return botonLayout;
	}


	private VerticalLayout buildDatoslayout() {
		
		datosLayout = new VerticalLayout();
		datosLayout.setWidth("100%");
		datosLayout.setHeight("-1px");
		
		txtAlgo.setCaption("Ocupacion");
		datosLayout.addComponent(txtAlgo);
	
		return datosLayout;
	}
	
	
	
	

}
