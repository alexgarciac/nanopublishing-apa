package org.nanotate;

import javax.servlet.annotation.WebServlet;

import org.nanotate.ui.Login;
import org.nanotate.ui.Main;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("nanotate")
@Push
public class Nanotate_UI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Nanotate_UI.class, widgetset="org.nanotate.widgetset.Nanotate_vaadinWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		
		
		Login login = new Login();
		
		
		Main main = new Main(this);
		
		this.setContent(login);
		
	}

}