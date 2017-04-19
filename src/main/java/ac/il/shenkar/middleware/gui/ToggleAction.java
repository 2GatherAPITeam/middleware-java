package ac.il.shenkar.middleware.gui;

import ac.il.shenkar.middleware.config.SampleTomcatApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ToggleAction extends MouseAdapter {

	private ConfigurableApplicationContext context;

	public void setContext(ConfigurableApplicationContext context) {
		this.context = context;
	}

	@Override
	public void mouseReleased( MouseEvent e ) {
		if(context != null && context.isActive()){
			context.close();
		}else{
			setContext(SpringApplication.run(SampleTomcatApplication.class, new String[]{}));
		}
	}
}
