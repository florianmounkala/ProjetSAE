import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Rapport.CreatePDF;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Ajouter_solde_tout_compte extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldnom;
	private JTextField textFieldprenom;
	private JTextField textField_ref;
	private JTextField textField_date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ajouter_solde_tout_compte frame = new Ajouter_solde_tout_compte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ajouter_solde_tout_compte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Ajouter un solde de tout compte");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_3);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_4);
		
		JLabel Nom_loc = new JLabel("Nom du locataire");
		panel.add(Nom_loc);
		
		textFieldnom = new JTextField();
		panel.add(textFieldnom);
		textFieldnom.setColumns(10);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_5);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_6);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_7);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_8);
		
		JLabel lblNewLabelPrenom_loc = new JLabel("Prenom du locataire");
		panel.add(lblNewLabelPrenom_loc);
		
		textFieldprenom = new JTextField();
		panel.add(textFieldprenom);
		textFieldprenom.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut_2);
		
		JLabel lblNewLabel_Référence = new JLabel("R\u00E9f\u00E9rence");
		panel.add(lblNewLabel_Référence);
		
		textField_ref = new JTextField();
		panel.add(textField_ref);
		textField_ref.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Date du solde (date actuelle):");
		panel.add(lblNewLabel_4);
		
		textField_date = new JTextField();
		panel.add(textField_date);
		textField_date.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButtonAnnuler = new JButton("Annuler");
		btnNewButtonAnnuler.addActionListener(this);
		panel_1.add(btnNewButtonAnnuler);
		
		JButton btnNewButtonValider = new JButton("Valider");
		btnNewButtonValider.addActionListener(this);
		panel_1.add(btnNewButtonValider);
	}

	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
			case "Annuler":
				FenetrePrincipal fenp;
			try {
				fenp = new FenetrePrincipal();
				fenp.setVisible(true);
				fenp.toFront();
				this.dispose();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;	
			case "Valider":
				CreatePDF Solde_tcmpt;
				Solde_tcmpt = new CreatePDF(textFieldprenom.getText(), textFieldnom.getText(), textField_date.getText() , textField_ref.getText());
				Solde_tcmpt.main(null);
				Solde_tcmpt.EnregistrerRapport();
				
				break;
				
				
		}
	}
}
