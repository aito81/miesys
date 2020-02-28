package py.com.sgipy.miesys.events;

public class NavigationEvent {
	
	private String viewName;

    public NavigationEvent(String viewName) {
        this.viewName = viewName;
    }

    public String getViewName() {
        return viewName;
    }

}
