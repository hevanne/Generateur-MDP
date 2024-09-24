package ihm;

import javax.swing.*;

public class FrameMDP extends JFrame{
	
	public FrameMDP(){
		this.setTitle("Générateur de mot de passe");
		this.setSize(600, 400);
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(new PanelMDP());

		this.setVisible(true);
	}
}