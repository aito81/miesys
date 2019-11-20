package py.com.sgipy.miesys.events;

import py.com.sgipy.miesys.MiesysUI;;

public class EventBus {

	public static void register(final Object listener){
		MiesysUI.getEventBus().register(listener);
	}
	
	public static void unregister(final Object listener){
		MiesysUI.getEventBus().unregister(listener);
	}
	
	public static void post(final Object listener){
		MiesysUI.getEventBus().post(listener);
	}
}
