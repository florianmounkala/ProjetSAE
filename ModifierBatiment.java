import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifierBatiment extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldID_bat;
	private JTextField textField_New_adresse;
	private JTextField textField_nb_logement;
	private JTextField textField_ville;
	private JTextField textField_code_postal;
	private JTextField textFieldnb_e;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierBatiment frame = new ModifierBatiment();
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
	public ModifierBatiment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{101, 123, 96, 0};
		gbl_panel.rowHeights = new int[]{19, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Id du batiment a modifier :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldID_bat = new JTextField();
		GridBagConstraints gbc_textFieldID_bat = new GridBagConstraints();
		gbc_textFieldID_bat.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldID_bat.anchor = GridBagConstraints.NORTHWEST;
		gbc_textFieldID_bat.gridx = 2;
		gbc_textFieldID_bat.gridy = 1;
		panel.add(textFieldID_bat, gbc_textFieldID_bat);
		textFieldID_bat.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nouvelle adresse :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_New_adresse = new JTextField();
		GridBagConstraints gbc_textField_New_adresse = new GridBagConstraints();
		gbc_textField_New_adresse.anchor = GridBagConstraints.WEST;
		gbc_textField_New_adresse.insets = new Insets(0, 0, 5, 0);
		gbc_textField_New_adresse.gridx = 2;
		gbc_textField_New_adresse.gridy = 2;
		panel.add(textField_New_adresse, gbc_textField_New_adresse);
		textField_New_adresse.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nouvelle ville :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_ville = new JTextField();
		GridBagConstraints gbc_textField_ville = new GridBagConstraints();
		gbc_textField_ville.anchor = GridBagConstraints.WEST;
		gbc_textField_ville.insets = new Insets(0, 0, 5, 0);
		gbc_textField_ville.gridx = 2;
		gbc_textField_ville.gridy = 3;
		panel.add(textField_ville, gbc_textField_ville);
		textField_ville.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nouveau code postal :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_code_postal = new JTextField();
		GridBagConstraints gbc_textField_code_postal = new GridBagConstraints();
		gbc_textField_code_postal.anchor = GridBagConstraints.WEST;
		gbc_textField_code_postal.insets = new Insets(0, 0, 5, 0);
		gbc_textField_code_postal.gridx = 2;
		gbc_textField_code_postal.gridy = 4;
		panel.add(textField_code_postal, gbc_textField_code_postal);
		textField_code_postal.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nombres de logements :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_nb_logement = new JTextField();
		GridBagConstraints gbc_textField_nb_logement = new GridBagConstraints();
		gbc_textField_nb_logement.insets = new Insets(0, 0, 5, 0);
		gbc_textField_nb_logement.anchor = GridBagConstraints.WEST;
		gbc_textField_nb_logement.gridx = 2;
		gbc_textField_nb_logement.gridy = 5;
		panel.add(textField_nb_logement, gbc_textField_nb_logement);
		textField_nb_logement.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("nb_\u00E9tages :");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textFieldnb_e = new JTextField();
		GridBagConstraints gbc_textFieldnb_e = new GridBagConstraints();
		gbc_textFieldnb_e.anchor = GridBagConstraints.WEST;
		gbc_textFieldnb_e.gridx = 2;
		gbc_textFieldnb_e.gridy = 6;
		panel.add(textFieldnb_e, gbc_textFieldnb_e);
		textFieldnb_e.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButtonValider = new JButton("Valider");
		btnNewButtonValider.addActionListener(this);
		panel_1.add(btnNewButtonValider);
		
		JButton btnNewButtonAnnuler = new JButton("Annuler");
		btnNewButtonAnnuler.addActionListener(this);
		panel_1.add(btnNewButtonAnnuler);
		
		JLabel lblNewLabelTitre = new JLabel("Modifier un batiment");
		lblNewLabelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabelTitre, BorderLayout.NORTH);
		
	}
	private static Connection getConnection() throws SQLException {
    	// Connexion à la base de données
    	CictOracleDataSource bd = new CictOracleDataSource();
    	Connection cn = bd.getConnection();
		return cn;
    }
	
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		switch(button.getText()) {
		case "Annuler":
			Fenetre_Batiment Fenbat2;
			Fenbat2 = new Fenetre_Batiment();
			Fenbat2.setVisible(true);
			Fenbat2.toFront();
			this.dispose();
			break;
		case "Valider":
			String requete = "{call MODIFIER__BATIMENT(?, ?, ?, ?, ?, ?)}";
			try {
				
				Connection conn = getConnection();
				CallableStatement cstmt = conn.prepareCall(requete);
				cstmt.setInt(1,Integer.parseInt(textFieldID_bat.getText()));
				cstmt.setInt(2,Integer.parseInt(textField_nb_logement.getText()));
				cstmt.setString(3, textField_code_postal.getText());
				cstmt.setString(4, textFieldnb_e.getText());
				cstmt.setString(5, textField_New_adresse.getText());
				cstmt.setString(6,textField_ville.getText());
				cstmt.execute();
				Fenetre_Batiment Fenbat;
				Fenbat = new Fenetre_Batiment();
				Fenbat.setVisible(true);
				Fenbat.toFront();
				this.dispose();
				break;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
