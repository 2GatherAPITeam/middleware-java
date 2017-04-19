package ac.il.shenkar.middleware.gui;

import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

public class AppFrame extends JFrame {

	private ConfigurableApplicationContext context;
	private ToggleAction action;
	private JSwitchBox switchBox;

	public AppFrame() {
		this.setLayout(new BorderLayout());
		this.setTitle("2GatherAPI-MiddleWare");
		this.getContentPane().setPreferredSize(new Dimension(300, 50));
		action = new ToggleAction();
		switchBox = new JSwitchBox( "ON","OFF", action);
		this.add(switchBox, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}