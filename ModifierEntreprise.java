import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ModifierEntreprise extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField_Siren;
	private JTextField textFieldNom;
	private JTextField textField_Adresse;
	private JTextField textField_CodePostal;
	private JTextField textField_Telephone;
	private JTextField textField_email;
	private JTextField textField_Iban;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifierEntreprise frame = new ModifierEntreprise();
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
	public ModifierEntreprise() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Modifier Entreprise\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_1 = new JLabel("Siren de l'entreprise a modifier :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_Siren = new JTextField();
		GridBagConstraints gbc_textField_Siren = new GridBagConstraints();
		gbc_textField_Siren.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Siren.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Siren.gridx = 0;
		gbc_textField_Siren.gridy = 1;
		panel.add(textField_Siren, gbc_textField_Siren);
		textField_Siren.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nom :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFieldNom = new JTextField();
		GridBagConstraints gbc_textFieldNom = new GridBagConstraints();
		gbc_textFieldNom.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNom.gridx = 2;
		gbc_textFieldNom.gridy = 2;
		panel.add(textFieldNom, gbc_textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Adresse :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 3;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_Adresse = new JTextField();
		GridBagConstraints gbc_textField_Adresse = new GridBagConstraints();
		gbc_textField_Adresse.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Adresse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Adresse.gridx = 2;
		gbc_textField_Adresse.gridy = 3;
		panel.add(textField_Adresse, gbc_textField_Adresse);
		textField_Adresse.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Code postal :");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 4;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_CodePostal = new JTextField();
		GridBagConstraints gbc_textField_CodePostal = new GridBagConstraints();
		gbc_textField_CodePostal.insets = new Insets(0, 0, 5, 5);
		gbc_textField_CodePostal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_CodePostal.gridx = 2;
		gbc_textField_CodePostal.gridy = 4;
		panel.add(textField_CodePostal, gbc_textField_CodePostal);
		textField_CodePostal.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("T\u00E9l\u00E9phone :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 5;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_Telephone = new JTextField();
		GridBagConstraints gbc_textField_Telephone = new GridBagConstraints();
		gbc_textField_Telephone.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Telephone.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Telephone.gridx = 2;
		gbc_textField_Telephone.gridy = 5;
		panel.add(textField_Telephone, gbc_textField_Telephone);
		textField_Telephone.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Iban :");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 6;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textField_Iban = new JTextField();
		GridBagConstraints gbc_textField_Iban = new GridBagConstraints();
		gbc_textField_Iban.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Iban.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Iban.gridx = 2;
		gbc_textField_Iban.gridy = 6;
		panel.add(textField_Iban, gbc_textField_Iban);
		textField_Iban.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("E-mail :");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 7;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		textField_email = new JTextField();
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.insets = new Insets(0, 0, 0, 5);
		gbc_textField_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_email.gridx = 2;
		gbc_textField_email.gridy = 7;
		panel.add(textField_email, gbc_textField_email);
		textField_email.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Annuler");
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Valider");
		btnNewButton_1.addActionListener(this);
		panel_1.add(btnNewButton_1);
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
			Fenetre_entreprise Fenent2;
			Fenent2 = new Fenetre_entreprise();
			Fenent2.setVisible(true);
			Fenent2.toFront();
			this.dispose();
			break;
		case "Valider":
			String requete = "{call MODIFIER_ENTREPRISE(?, ?, ?, ?, ?, ?, ?)}";
			try {
				
				Connection conn = getConnection();
				CallableStatement cstmt = conn.prepareCall(requete);
				cstmt.setString(1,textField_Siren.getText());
				cstmt.setString(2,textFieldNom.getText());
				cstmt.setString(3, textField_Adresse.getText());
				cstmt.setString(4, textField_CodePostal.getText());
				cstmt.setString(5, textField_Iban.getText());
				cstmt.setString(6,textField_email.getText());
				cstmt.setString(7,textField_Telephone.getText());
				cstmt.execute();
				Fenetre_entreprise Fenent;
				Fenent = new Fenetre_entreprise();
				Fenent.setVisible(true);
				Fenent.toFront();
				this.dispose();
				break;
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
