

import java.awt.*;

import javax.swing.*;

public class Unavailable_ServiceFrame extends JFrame{
	
	Unavailable_ServicePanel panel;
	
	Unavailable_ServiceFrame(){
		
		panel = new Unavailable_ServicePanel();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}  

}
