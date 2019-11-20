package py.com.sgipy.miesys.events;

import com.vaadin.ui.UI;

public class LogoutEvent {
	public LogoutEvent(){
		UI.getCurrent().getPage().setUriFragment("");
	}
}
