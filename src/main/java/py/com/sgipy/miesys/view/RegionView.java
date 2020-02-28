package py.com.sgipy.miesys.view;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

public class RegionView extends CustomComponent implements View {

	
	private VerticalLayout mainLayout;
	private VerticalLayout formLayout;
	private VerticalLayout datosLayout;
	private HorizontalLayout botonLayout;
	
	
	public RegionView() {
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
	}


	private void buildMainLayout() {
		// TODO Auto-generated method stub
		
	}
	
	
}
