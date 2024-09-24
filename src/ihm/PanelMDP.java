package ihm;

import java.awt.Font;
import java.awt.BorderLayout;

import javax.swing.*;

public class PanelMDP extends JPanel{
	private JPanel pnlHaut;
	private JPanel pnlBas;
	private JPanel pnlCentre;

	private JLabel     lblTitre;
	private JLabel     lblExplications;
	private JTextField txtNbCar;
	private JCheckBox  cbChiffres;
	private JCheckBox  cbCarSpeciaux;
	private JButton    btnGenerer;

	public PanelMDP(){
		this.setLayout(new BorderLayout());

		this.pnlHaut   = new JPanel();
		this.pnlBas    = new JPanel();
		this.pnlCentre = new JPanel();

		this.lblTitre = new JLabel("Générateur de mot de passe");
		this.lblTitre.setFont(new Font(lblTitre.getFont().getName(), Font.BOLD, 20));

		this.lblExplications = new JLabel( "<html><div style='text-align: center;'>Cette application permet de générer un mot de passe aléatoire.<br>" +
						"Vous devez entrer le nombre de caractères souhaités, <br>" +
						"et cocher les cases si vous souhaitez des chiffres et des caractères spéciaux dans votre mot de passe.</div></html>");

		this.lblExplications.setFont(new Font(lblExplications.getFont().getName(), Font.PLAIN, 12));

		this.txtNbCar      = new JTextField(5);
		this.cbChiffres    = new JCheckBox("Chiffres");
		this.cbCarSpeciaux = new JCheckBox("Caractères spéciaux");
		this.btnGenerer    = new JButton("Générer");

		this.pnlHaut.add(this.lblTitre);
		this.pnlCentre.add(this.lblExplications);

		this.pnlCentre.add(new JLabel("Nombre de caractères : (max 35) "));
		this.pnlCentre.add(this.txtNbCar);
		this.pnlCentre.add(this.cbChiffres);
		this.pnlCentre.add(this.cbCarSpeciaux);

		this.pnlBas.add(this.btnGenerer);

		this.add(this.pnlHaut  , BorderLayout.NORTH);
		this.add(this.pnlCentre, BorderLayout.CENTER);
		this.add(this.pnlBas   , BorderLayout.SOUTH);
	}
}